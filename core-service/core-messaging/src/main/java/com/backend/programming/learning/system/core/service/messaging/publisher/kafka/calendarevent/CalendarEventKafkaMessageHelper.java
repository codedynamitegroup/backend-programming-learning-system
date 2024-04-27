package com.backend.programming.learning.system.core.service.messaging.publisher.kafka.calendarevent;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;
@Component
@Slf4j
public class CalendarEventKafkaMessageHelper {
    public <T> ListenableFutureCallback<SendResult<String, T>>
    getKafkaCallback(String topicName, T avroModel, String contestId, String userId, String avroModelName) {

        return new ListenableFutureCallback<SendResult<String, T>>() {

            @Override
            public void onFailure(Throwable ex) {
                log.error("Error while sending " + avroModelName +
                        " with contest id {} and user id {} to topic {}", contestId, userId, topicName);
            }

            @Override
            public void onSuccess(SendResult<String, T> result) {
                RecordMetadata metadata = result.getRecordMetadata();
                log.info("Received successful response from kafka for contest id {} and user id {} " +
                                "Topic: {}, Partition: {}, Timestamp: {}, Offset: {}",
                        contestId,
                        userId,
                        metadata.topic(),
                        metadata.partition(),
                        metadata.timestamp(),
                        metadata.offset());

            }
        };
    }
}
