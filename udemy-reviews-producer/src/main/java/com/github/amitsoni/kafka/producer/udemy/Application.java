package com.github.amitsoni.kafka.producer.udemy;

import com.github.amitsoni.avro.udemy.Review;
import com.github.amitsoni.kafka.producer.udemy.config.AppConfig;
import com.github.amitsoni.kafka.producer.udemy.runnable.ReviewsFetcherThread;
import com.github.amitsoni.kafka.producer.udemy.runnable.ReviewsProducerThread;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;

public class Application {

    Logger logger = LoggerFactory.getLogger(Application.class.getSimpleName());

    // thread safe queue which block when queue is full
    private ExecutorService executorService;
    private CountDownLatch latch;
    private ReviewsFetcherThread udemyRestApiClient;
    private ReviewsProducerThread reviewsProducerThread;

    public Application() {
        AppConfig appConfig = new AppConfig(ConfigFactory.load());
        ArrayBlockingQueue<Review> blockingQueue = new ArrayBlockingQueue<>(appConfig.getQueueCapacity());
        executorService = Executors.newFixedThreadPool(2);
        this.latch = new CountDownLatch(2);
        this.udemyRestApiClient = new ReviewsFetcherThread(latch, blockingQueue, appConfig);
        this.reviewsProducerThread = new ReviewsProducerThread(appConfig, latch, blockingQueue);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }

    private void start() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if(!executorService.isShutdown()) {
                logger.info("Shutdown requested .............");
                shutdown();
            }
        }));

        logger.info("Application started................");
        executorService.submit(udemyRestApiClient);
        executorService.submit(reviewsProducerThread);
        logger.info("Stuff submit ...................");

        try {
            logger.info("Latch await..........................");
            latch.await();
            logger.info("Thread completed.......................");
        } catch (InterruptedException e) {
            logger.warn("Some problem in latch await ...................");
            e.printStackTrace();
        } finally {
            shutdown();
            logger.info("Application closed successfully................");
        }

    }

    private void shutdown() {
        if(!executorService.isShutdown()) {

            logger.info("Shutting down ..................");
            executorService.shutdownNow();
            try {
                if(!executorService.awaitTermination(2000, TimeUnit.MILLISECONDS)) {
                    logger.warn("Executor did not terminate in the specified time."); //optional *
                    List<Runnable> droppedTasks =  executorService.shutdownNow(); //optional *
                    logger.warn("Executor was abruptly shut down. " + droppedTasks.size() + " tasks will not be executed."); //optional **
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
