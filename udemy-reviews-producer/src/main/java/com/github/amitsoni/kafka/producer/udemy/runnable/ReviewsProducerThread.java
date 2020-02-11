package com.github.amitsoni.kafka.producer.udemy.runnable;

import com.github.amitsoni.avro.udemy.Review;
import com.github.amitsoni.kafka.producer.udemy.config.AppConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class ReviewsProducerThread implements Runnable {

    private Logger logger = LoggerFactory.getLogger(ReviewsProducerThread.class.getSimpleName());

    private final AppConfig appConfig;
    private final CountDownLatch latch;
    private final ArrayBlockingQueue<Review> reviewArrayBlockingQueue;
    private final String topic;
    private final KafkaProducer<Long, Review> kafkaProducer;

    public ReviewsProducerThread(AppConfig appConfig, CountDownLatch latch, ArrayBlockingQueue<Review> reviewArrayBlockingQueue) {
        this.appConfig = appConfig;
        this.latch = latch;
        this.reviewArrayBlockingQueue = reviewArrayBlockingQueue;
        this.topic = appConfig.getTopicName();
        this.kafkaProducer = createKafkaProducer();
    }

    private KafkaProducer<Long, Review> createKafkaProducer() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, appConfig.getBootstrapServers());
        properties.put(ProducerConfig.ACKS_CONFIG, "all");
//        properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
        properties.put(ProducerConfig.RETRIES_CONFIG, Integer.MAX_VALUE);
        properties.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 1);
        properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, appConfig.getSchemaRegistryUrl());
        return new KafkaProducer<>(properties);
    }

    @Override
    public void run() {
        int reviewCount = 0;

        try{
            while (latch.getCount() > 1 || reviewArrayBlockingQueue.size() > 0) {
                Review review = reviewArrayBlockingQueue.poll();

                if(review == null) {
                    logger.info("waiting for review ...................");
                    Thread.sleep(200);
                }
                else {
                    reviewCount += 1;
                    logger.info("Receiving   " +  reviewCount +" review......");
//                    logger.info(review.toString());
                    ProducerRecord<Long, Review> producerRecord = new ProducerRecord<>(topic, review);
                    kafkaProducer.send(producerRecord);
                    kafkaProducer.flush();
                    Thread.sleep(appConfig.getProducerFrequencyMs());
                }
            }
        } catch (InterruptedException e) {
            logger.error("");
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public void close() {
        logger.info("Shut downing the producer........");
        kafkaProducer.flush();
        kafkaProducer.close();
        latch.countDown();
        logger.info("Producer shutdown.");
    }
}
