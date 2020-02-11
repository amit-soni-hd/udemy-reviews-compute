package com.github.amitsoni.kafka.stream.udemy.aggregator.aggregator;

import com.github.amitsoni.avro.udemy.CourseStatistic;
import com.github.amitsoni.avro.udemy.Review;
import com.github.amitsoni.kafka.stream.udemy.aggregator.config.AppConfig;
import com.github.amitsoni.kafka.stream.udemy.aggregator.timestamp.ReviewTimestampExtractor;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.WindowStore;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Properties;

public class Aggregator {

    private Logger logger = LoggerFactory.getLogger(Aggregator.class.getSimpleName());
    private AppConfig appConfig;

    public Aggregator(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    private Properties getKafkaStreamConfig() {

        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, appConfig.getApplicationId());
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, appConfig.getBootstrapServers());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.StringSerde.class);
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class);
        properties.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, appConfig.getSchemaRegistryUrl());

        return  properties;
    }

    public void start() {
        logger.info("Application started............");
        Properties properties = getKafkaStreamConfig();
        KafkaStreams kafkaStreams = createTopology(properties);
        kafkaStreams.cleanUp();
        kafkaStreams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));

        logger.info("Review processed................");
    }

    private KafkaStreams createTopology(Properties properties) {

        // create SerDes for KStream
        SpecificAvroSerde<Review> reviewSpecificAvroSerde = new SpecificAvroSerde<>();
        SpecificAvroSerde<CourseStatistic> courseStatisticSpecificAvroSerde = new SpecificAvroSerde<>();

        // configure SerDes with topic
        reviewSpecificAvroSerde.configure(Collections.singletonMap(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, appConfig.getSchemaRegistryUrl()), false);
        courseStatisticSpecificAvroSerde.configure(Collections.singletonMap(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, appConfig.getSchemaRegistryUrl()), false);

        Serdes.LongSerde longSerde = new Serdes.LongSerde();
        Serdes.StringSerde stringSerde = new Serdes.StringSerde();


        // create stream builder object
        StreamsBuilder streamsBuilder = new StreamsBuilder();

        // build KStream with timestamp extractor
        KStream<String, Review> validReview = streamsBuilder.stream(
                appConfig.getValidTopicName(),
                Consumed.with(longSerde,
                        reviewSpecificAvroSerde,
                        new ReviewTimestampExtractor(),
                        null)
                ).selectKey(((key, value) -> value.getCourse().getId().toString()));

        KTable<String, CourseStatistic> longTermStates = validReview
                .groupByKey().aggregate(
                      this::init,
                      this::reviewAggregator,
                     Materialized.<String, CourseStatistic, KeyValueStore<Bytes, byte[]>>as("long-term-statistic")
                        .withValueSerde(courseStatisticSpecificAvroSerde)
                );

        // long term states
        longTermStates.toStream()
                .peek((key, value) -> logger.info("long-term-states : key -> " + key + " value  -> " + value ))
                .to(appConfig.getLongTermStatsTopicName(), Produced.with(stringSerde, courseStatisticSpecificAvroSerde));

        Duration windowSize = Duration.standardDays(90l);
        Duration advanceSize = Duration.standardDays(1l);
        long windowSizeMs = windowSize.getMillis();
        long advanceSizeMs = advanceSize.getMillis();

        // create the time window of 90 days with 1 advance day for hopping window
        TimeWindows timeWindow = TimeWindows
                .of(java.time.Duration.ofDays(90L))
                .advanceBy(java.time.Duration.ofDays(1L));

        KTable<Windowed<String>, CourseStatistic> windowedCourseStatisticKTable = validReview
                .filter((key, value) -> !isReviewExpired(value, windowSizeMs))
                .groupByKey()
                .windowedBy(timeWindow)
                .aggregate(
                        this::init,
                        this::reviewAggregator,
                        Materialized.<String, CourseStatistic, WindowStore<Bytes, byte[]>>as("latest-statistic")
                        .withValueSerde(courseStatisticSpecificAvroSerde)
                );

        // recent statistic
        KStream<String, CourseStatistic> recentStates = windowedCourseStatisticKTable
                .toStream()
                .filter((window, courseState) -> keepCurrentWindow(window, advanceSizeMs))
                .peek((key, value) -> logger.info(value.toString()))
                .selectKey((key, value) -> key.key());

        // store in topic
        recentStates
                .peek((key, value) -> logger.info("recent-states : key -> " + key + " value -> " + value))
                .to(appConfig.getRecentStatsTopicName(), Produced.with(stringSerde, courseStatisticSpecificAvroSerde));

        return new KafkaStreams(streamsBuilder.build(), properties);
    }

    private Boolean keepCurrentWindow(Windowed<String> window, long advanceSizeMs) {

        long currentTime = System.currentTimeMillis();
        return window.window().end() > currentTime && window.window().end() < currentTime + advanceSizeMs;
    }

    private Boolean isReviewExpired(Review value, long windowSizeMs) {
        return (value.getCreated().getMillis() + windowSizeMs) < System.currentTimeMillis();
    }

    private CourseStatistic reviewAggregator(String s, Review review, CourseStatistic courseStatistic) {
        CourseStatistic.Builder courseStatisticBuilder = CourseStatistic.newBuilder(courseStatistic);

        courseStatisticBuilder.setCourseId(review.getCourse().getId());
        courseStatisticBuilder.setCourseTitle(courseStatistic.getCourseTitle());

        String reviewRating = review.getRating().toString();
        logger.info("review rating : " + reviewRating);

        // increase or decrease
        Integer incOrDec = reviewRating.contains("-") ? -1 : 1;
        logger.info(incOrDec.toString());

        switch(reviewRating.replace("-", "")) {

            case "0.5" :
                courseStatisticBuilder.setCountZeroStar(courseStatistic.getCountZeroStar() + incOrDec);
                break;
            case "1.0" :
            case "1.5" :
                courseStatisticBuilder.setCountOneStar(courseStatistic.getCountOneStar() + incOrDec);
                break;
            case "2.0" :
            case "2.5" :
                courseStatisticBuilder.setCountTwoStars(courseStatistic.getCountTwoStars() + incOrDec);
                break;
            case "3.0" :
            case "3.5" :
                courseStatisticBuilder.setCountThreeStars(courseStatistic.getCountThreeStars() + incOrDec);
                break;
            case "4.0" :
            case "4.5" :
                courseStatisticBuilder.setCountFourStars(courseStatistic.getCountFourStars() + incOrDec);
                break;
            case "5.0" :
                courseStatisticBuilder.setCountFiveStars(courseStatistic.getCountFiveStars() + incOrDec);
                break;
        }

        long newCountReview = courseStatistic.getCountReviews() + incOrDec;
        courseStatisticBuilder.setCountReviews(newCountReview);

        Double newRattingSum = courseStatistic.getSumRating() + new Double(review.getRating().toString());
        Double newRattingAvg = newRattingSum / newCountReview;

        courseStatisticBuilder.setAverageRating(newRattingAvg);
        courseStatisticBuilder.setSumRating(newRattingSum);
        courseStatisticBuilder.setLastReviewTime(latest(review.getCreated(), courseStatistic.getLastReviewTime()));

        return courseStatisticBuilder.build();
    }

    private DateTime latest(DateTime reviewCreated, DateTime lastReviewTime) {
        return reviewCreated.isAfter(lastReviewTime) ? reviewCreated : lastReviewTime;
    }

    private CourseStatistic init() {
        return CourseStatistic.newBuilder()
                .setLastReviewTime(new DateTime(0L))
                .build();
    }


}
