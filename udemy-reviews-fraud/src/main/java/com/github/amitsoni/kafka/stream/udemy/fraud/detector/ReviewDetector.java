package com.github.amitsoni.kafka.stream.udemy.fraud.detector;

import com.github.amitsoni.avro.udemy.Review;
import com.github.amitsoni.kafka.stream.udemy.fraud.config.AppConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.common.utils.Utils;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class ReviewDetector {

    private Logger logger = LoggerFactory.getLogger(ReviewDetector.class.getSimpleName());

    private AppConfig appConfig;

    public ReviewDetector(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void start() {
        logger.info("Application started............ ");
        Properties properties = getKafkaStreamsConfig();
        KafkaStreams kafkaStreams = createTopology(properties);
        kafkaStreams.cleanUp();
        kafkaStreams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
        logger.info("Review processed...........");
    }

    private Properties getKafkaStreamsConfig(){
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, appConfig.getApplicationId());
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, appConfig.getBootstrapServer());
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        // we disable the cache to demonstrate all the "steps" involved in the transformation - not recommended in prod
        config.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, "0");

        // Exactly once processing!!
        config.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE);
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class.getName());
        config.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, appConfig.getSchemaRegistryUrl());

        return config;
    }

    private KafkaStreams createTopology(Properties config) {
        StreamsBuilder builder = new StreamsBuilder();

        KStream<Bytes, Review> udemyReviews = builder.stream(appConfig.getSourceTopicName());

        KStream<Bytes, Review>[] branches = udemyReviews.branch(
                (k, review) -> isValidReview(review),
                (k, review) -> true
        );

        KStream<Bytes, Review> validReviews = branches[0];
        KStream<Bytes, Review> fraudReviews = branches[1];

        validReviews.peek((k, review) -> logger.info("Valid: " + review.getId())).to(appConfig.getValidTopicName());
        fraudReviews.peek((k, review) -> logger.info("!! Fraud !!: " + review.getId())).to(appConfig.getFraudTopicName());

        return new KafkaStreams(builder.build(), config);
    }

    // this could very well be a check against a model that's been computed with machine learning
    // in this case we just do a quick hash to randomize the sample
    // and filter out 5% of the reviews randomly, but predictably (!)
    private boolean isValidReview(Review review) {

        try {
            int hash = Utils.toPositive(Utils.murmur2(review.toByteBuffer().array()));
            return (hash % 100) >=5;  // 95 % of the reviews will be valid reviews
        } catch (IOException e) {
            return false;
        }
    }
}
