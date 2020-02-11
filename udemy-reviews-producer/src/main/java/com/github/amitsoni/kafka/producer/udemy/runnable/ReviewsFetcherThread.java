package com.github.amitsoni.kafka.producer.udemy.runnable;

import com.github.amitsoni.avro.udemy.Review;
import com.github.amitsoni.kafka.producer.udemy.client.UdemyRestApiClient;
import com.github.amitsoni.kafka.producer.udemy.config.AppConfig;
import org.apache.http.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class ReviewsFetcherThread implements Runnable {

    private Logger logger = LoggerFactory.getLogger(ReviewsFetcherThread.class.getSimpleName());

    private CountDownLatch latch;
    private ArrayBlockingQueue<Review> reviewsQueue;
    private UdemyRestApiClient udemyRestApiClient;
    private AppConfig appConfig;

    public ReviewsFetcherThread(CountDownLatch latch, ArrayBlockingQueue<Review> reviewsQueue, AppConfig appConfig) {
        this.latch = latch;
        this.reviewsQueue = reviewsQueue;
        this.appConfig = appConfig;
        this.udemyRestApiClient = new UdemyRestApiClient(appConfig);
    }

    @Override
    public void run() {

        Boolean keepOnRunning = true;
        try {
            while (keepOnRunning) {
                List<Review> reviewList;
                try {
                    reviewList = udemyRestApiClient.getNextReviews();
                    logger.info("..................... Fetch " + reviewList.size() + " reviews .......................");
                    if (reviewList.size() == 0) {
                        keepOnRunning = false;
                    } else {
                        logger.info("...............Queue size is " + reviewsQueue.size() + " .......................");
                        for (Review review : reviewList) {
                            reviewsQueue.put(review);
                        }
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    Thread.sleep(500);
                } finally {
                    Thread.sleep(50);
                }
            }
        } catch (InterruptedException e) {
            logger.warn("Rest client Interrupted");
            e.printStackTrace();
        } finally {
            this.close();
        }
    }

    private void close() {
        logger.info("closing.............");
        udemyRestApiClient.close();
        latch.countDown();
        logger.info("Closed...............");
    }
}
