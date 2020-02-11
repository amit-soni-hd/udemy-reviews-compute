package com.github.amitsoni.kafka.stream.udemy.aggregator;

import com.github.amitsoni.kafka.stream.udemy.aggregator.aggregator.Aggregator;
import com.github.amitsoni.kafka.stream.udemy.aggregator.config.AppConfig;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Application.class.getSimpleName());

        logger.info("Application starting............");
        Aggregator aggregator = new Aggregator(new AppConfig(ConfigFactory.load()));
        aggregator.start();
        logger.info("Application shutdown............");
    }
}
