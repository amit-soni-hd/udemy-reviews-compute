package com.github.amitsoni.kafka.stream.udemy.fraud;

import com.github.amitsoni.kafka.stream.udemy.fraud.config.AppConfig;
import com.github.amitsoni.kafka.stream.udemy.fraud.detector.ReviewDetector;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Application.class.getSimpleName());
        logger.info("Application starting .................");

        ReviewDetector reviewDetector = new ReviewDetector(new AppConfig(ConfigFactory.load()));
        reviewDetector.start();

        logger.info("Application shutdown...............");

    }
}
