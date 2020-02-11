package com.github.amitsoni.kafka.producer.udemy.config;

import com.typesafe.config.Config;

public class AppConfig {

    private final String bootstrapServers;
    private final String schemaRegistryUrl;
    private final String topicName;
    private final Integer queueCapacity;
    private final Integer producerFrequencyMs;
    private final Integer udemyPageSize;
    private final String courseId;
    private final String client_id;
    private final String client_secret;

    public AppConfig(Config config) {
        this.bootstrapServers = config.getString("kafka.bootstrap.servers");
        this.schemaRegistryUrl = config.getString("kafka.schema.registry.url");
        this.courseId = config.getString("app.course.id");
        this.producerFrequencyMs = config.getInt("app.producer.frequency.ms");
        this.udemyPageSize = config.getInt("app.udemy.page.size");
        this.topicName = config.getString("kafka.topic.name");
        this.queueCapacity = config.getInt("app.queue.capacity");
        this.client_id = config.getString("udemy.client.id");
        this.client_secret = config.getString("udemy.client.secret");
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public String getSchemaRegistryUrl() {
        return schemaRegistryUrl;
    }

    public String getTopicName() {
        return topicName;
    }

    public Integer getQueueCapacity() {
        return queueCapacity;
    }

    public Integer getProducerFrequencyMs() {
        return producerFrequencyMs;
    }

    public Integer getUdemyPageSize() {
        return udemyPageSize;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }
}
