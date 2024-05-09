package com.backend.programming.learning.system.code.assessment.service.messaging.publisher.kafka.code_question;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;
@Component
@Slf4j
public class CodeQuestionKafkaMessageHelper {
    public <T> ListenableFutureCallback<SendResult<String, T>>
    getKafkaCallback
            (String topicName,
             T avroModel, String codeQuestionId, String avroModelName) {

        return new ListenableFutureCallback<SendResult<String, T>>() {

            @Override
            public void onFailure(Throwable ex) {
                log.error("Error while sending "+avroModelName +
                        " id {} to topic {}", codeQuestionId, topicName);
            }

            @Override
            public void onSuccess(SendResult<String, T> result) {
                RecordMetadata metadata = result.getRecordMetadata();
                log.info("Received successful response from kafka for code question id {} " +
                                "Topic: {}, Partition: {}, Timestamp: {}, Offset: {}",
                        codeQuestionId,
                        metadata.topic(),
                        metadata.partition(),
                        metadata.timestamp(),
                        metadata.offset());

            }
        };
    }
}
