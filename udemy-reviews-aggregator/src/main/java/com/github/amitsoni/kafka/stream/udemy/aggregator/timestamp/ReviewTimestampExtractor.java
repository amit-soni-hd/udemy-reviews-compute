package com.github.amitsoni.kafka.stream.udemy.aggregator.timestamp;

import com.github.amitsoni.avro.udemy.Review;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;

public class ReviewTimestampExtractor implements TimestampExtractor {
    @Override
    public long extract(ConsumerRecord<Object, Object> consumerRecord, long previousTimestamp) {

        long timestamp = -1;
        Review review= (Review)consumerRecord.value();

        //get time if review exist
        if(review !=null)
            timestamp = review.getCreated().getMillis();

        if(timestamp < 0) {
            // handle wrong timestamp
            if(previousTimestamp < 0) {
                return System.currentTimeMillis();
            } else {
                return previousTimestamp;
            }
        } else {
            return timestamp;
        }
    }
}
