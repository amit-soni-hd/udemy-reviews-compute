package com.github.amitsoni.kafka.stream.udemy.fraud.config;

import com.typesafe.config.Config;

public class AppConfig {

    private String bootstrapServer;
    private String schemaRegistryUrl;
    private String sourceTopicName;
    private String validTopicName;
    private String fraudTopicName;
    private String applicationId;

    public AppConfig(Config config) {
        this.bootstrapServer = config.getString("kafka.bootstrap.servers");
        this.schemaRegistryUrl = config.getString("kafka.schema.registry.url");
        this.sourceTopicName = config.getString("kafka.source.topic.name");
        this.validTopicName = config.getString("kafka.valid.topic.name");
        this.fraudTopicName = config.getString("kafka.fraud.topic.name");
        this.applicationId = config.getString("kafka.streams.application.id");
    }

    public String getBootstrapServer() {
        return bootstrapServer;
    }

    public String getSchemaRegistryUrl() {
        return schemaRegistryUrl;
    }

    public String getSourceTopicName() {
        return sourceTopicName;
    }

    public String getValidTopicName() {
        return validTopicName;
    }

    public String getFraudTopicName() {
        return fraudTopicName;
    }

    public String getApplicationId() {
        return applicationId;
    }
}
