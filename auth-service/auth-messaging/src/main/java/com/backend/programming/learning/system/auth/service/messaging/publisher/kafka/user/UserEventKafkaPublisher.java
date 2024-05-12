package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka.user;

import com.backend.programming.learning.system.auth.service.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserResponseMessagePublisher;
import com.backend.programming.learning.system.auth.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserResponseAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaOutboxMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserEventKafkaPublisher implements UserResponseMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final KafkaProducer<String, UserResponseAvroModel> kafkaProducer;
    private final AuthServiceConfigData authServiceConfigData;
    private final KafkaOutboxMessageHelper kafkaOutboxMessageHelper;


    @Override
    public void publish(UserOutboxMessage userOutboxMessage, BiConsumer<UserOutboxMessage, OutboxStatus> outboxCallback) {
        UserEventPayload userEventPayload = kafkaOutboxMessageHelper.getEventPayload(userOutboxMessage.getPayload(), UserEventPayload.class);

        String sagaId = userOutboxMessage.getSagaId().toString();

        log.info("Received UserOutboxMessage for user id: {} and saga id: {}", userEventPayload.getUserId(), sagaId);

        try {
            UserResponseAvroModel userResponseAvroModel = userMessagingDataMapper
                    .userEventPayloadToUserResponseAvroModel(sagaId, userEventPayload);
            kafkaProducer.send(authServiceConfigData.getUserResponseTopicName(),
                    sagaId,
                    userResponseAvroModel,
                    kafkaOutboxMessageHelper.getKafkaCallback(authServiceConfigData.getUserResponseTopicName(),
                            userResponseAvroModel,
                            userOutboxMessage,
                            outboxCallback,
                            userEventPayload.getUserId(),
                            "UserResponseAvroModel"));
            log.info("UserResponseAvroModel sent to Kafka for user id: {} and saga id: {}", userEventPayload.getUserId(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending UserResponseAvroModel message" +
                    " to kafka with user id: {} and saga id: {}, error: {}", userEventPayload.getUserId(), sagaId, e.getMessage());
        }
    }
}
