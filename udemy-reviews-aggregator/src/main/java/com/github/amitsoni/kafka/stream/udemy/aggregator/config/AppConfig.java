package com.github.amitsoni.kafka.stream.udemy.aggregator.config;

import com.typesafe.config.Config;

public class AppConfig {

    private String bootstrapServers;
    private String schemaRegistryUrl;
    private String applicationId;
    private String validTopicName;
    private String longTermStatsTopicName;
    private String recentStatsTopicName;

    public AppConfig(Config config) {
        this.bootstrapServers = config.getString("kafka.bootstrap.servers");
        this.applicationId = config.getString("kafka.streams.application.id");
        this.schemaRegistryUrl = config.getString("kafka.schema.registry.url");
        this.validTopicName = config.getString("kafka.valid.topic.name");
        this.longTermStatsTopicName = config.getString("kafka.long.term.stats.topic.name");
        this.recentStatsTopicName = config.getString("kafka.recent.stats.topic.name");
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public String getSchemaRegistryUrl() {
        return schemaRegistryUrl;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getValidTopicName() {
        return validTopicName;
    }

    public String getLongTermStatsTopicName() {
        return longTermStatsTopicName;
    }

    public String getRecentStatsTopicName() {
        return recentStatsTopicName;
    }
}
