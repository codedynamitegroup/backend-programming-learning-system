package com.backend.programming.learning.system.kafka.producer;

import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

@Slf4j
@Component
public class KafkaOutboxMessageHelper {
    private final ObjectMapper objectMapper;

    public KafkaOutboxMessageHelper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public <T> T getEventPayload(String payload, Class<T> outputType) {
        try {
            return objectMapper.readValue(payload, outputType);
        } catch (JsonProcessingException e) {
            log.error("Could not read {} object!", outputType.getName(), e);
            throw new RuntimeException("Could not read " + outputType.getName() + " object!", e);
        }
    }

    public <T, U> CompletableFuture<SendResult<String, T>> getKafkaCallback(
            String responseTopicName, T avroModel, U outboxMessage,
                     BiConsumer<U, OutboxStatus> outboxCallback,
                     String objectId, String avroModelName) {
        CompletableFuture<SendResult<String, T>> future = new CompletableFuture<>();
        future.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Error while sending {} with message: {} and outbox type: {} to topic {}",
                        avroModelName, avroModel.toString(), outboxMessage.getClass().getName(), responseTopicName, ex);
                outboxCallback.accept(outboxMessage, OutboxStatus.FAILED);
            } else {
                RecordMetadata metadata = result.getRecordMetadata();
                log.info("Received successful response from Kafka for id: {}" +
                                " Topic: {} Partition: {} Offset: {} Timestamp: {}",
                        objectId,
                        metadata.topic(),
                        metadata.partition(),
                        metadata.offset(),
                        metadata.timestamp());
                outboxCallback.accept(outboxMessage, OutboxStatus.COMPLETED);
            }
        });
        return future;
    }

//    public <T, U> ListenableFutureCallback<SendResult<String, T>>
//    getKafkaCallback(String responseTopicName, T avroModel, U outboxMessage,
//                     BiConsumer<U, OutboxStatus> outboxCallback,
//                     String objectId, String avroModelName) {
//        return new ListenableFutureCallback<SendResult<String, T>>() {
//            @Override
//            public void onFailure(Throwable ex) {
//                log.error("Error while sending {} with message: {} and outbox type: {} to topic {}",
//                        avroModelName, avroModel.toString(), outboxMessage.getClass().getName(), responseTopicName, ex);
//                outboxCallback.accept(outboxMessage, OutboxStatus.FAILED);
//            }
//
//            @Override
//            public void onSuccess(SendResult<String, T> result) {
//                RecordMetadata metadata = result.getRecordMetadata();
//                log.info("Received successful response from Kafka for id: {}" +
//                                " Topic: {} Partition: {} Offset: {} Timestamp: {}",
//                        objectId,
//                        metadata.topic(),
//                        metadata.partition(),
//                        metadata.offset(),
//                        metadata.timestamp());
//                outboxCallback.accept(outboxMessage, OutboxStatus.COMPLETED);
//            }
//        };
//    }
}