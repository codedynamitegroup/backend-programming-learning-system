package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class UserKafkaMessageHelper {
    public  <T> ListenableFutureCallback<SendResult<String, T>>
    getKafkaCallback(String responseTopicName, T requestAvroModel, String userId, String requestAvroModelName) {
        return new ListenableFutureCallback<SendResult<String, T>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Error while sending " + requestAvroModelName +
                        " message {} to topic {}", requestAvroModel.toString(), responseTopicName, ex);
            }

            @Override
            public void onSuccess(SendResult<String, T> result) {
                RecordMetadata metadata = result.getRecordMetadata();
                log.info("Received metadata for UserRequestAvroModel message" +
                                " with user id: {}, topic: {}, partition: {}, offset: {}, timestamp: {}",
                        userId, metadata.topic(), metadata.partition(), metadata.offset(), metadata.timestamp());
            }
        };
    }
}
