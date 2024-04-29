package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka.user;

import com.backend.programming.learning.system.auth.service.domain.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserRequestMessagePublisher;
import com.backend.programming.learning.system.auth.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class UserEventKafkaPublisher implements UserRequestMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final KafkaProducer<String, UserRequestAvroModel> kafkaProducer;
    private final AuthServiceConfigData authServiceConfigData;
    private final UserKafkaMessageHelper userKafkaMessageHelper;
    private final ObjectMapper objectMapper;

    public UserEventKafkaPublisher(UserMessagingDataMapper userMessagingDataMapper, KafkaProducer<String, UserRequestAvroModel> kafkaProducer, AuthServiceConfigData authServiceConfigData, UserKafkaMessageHelper userKafkaMessageHelper, ObjectMapper objectMapper) {
        this.userMessagingDataMapper = userMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.authServiceConfigData = authServiceConfigData;
        this.userKafkaMessageHelper = userKafkaMessageHelper;
        this.objectMapper = objectMapper;
    }


    @Override
    public void publish(UserOutboxMessage userOutboxMessage, BiConsumer<UserOutboxMessage, OutboxStatus> outboxCallback) {
        UserEventPayload userEventPayload = getUserEventPayload(userOutboxMessage.getPayload());

        String sagaId = userOutboxMessage.getSagaId().toString();

        log.info("Received UserOutboxMessage for user id: {} and saga id: {}", userEventPayload.getUserId(), sagaId);

        try {
            switch (userEventPayload.getCopyState()) {
                case "CREATING":
                    UserRequestAvroModel userCreatedRequestAvroModel = userMessagingDataMapper
                            .userCreatedEventPayloadToUserCreateRequestAvroModel(sagaId, userEventPayload);

                    kafkaProducer.send(authServiceConfigData.getUserCreateRequestTopicName(),
                            sagaId,
                            userCreatedRequestAvroModel,
                            userKafkaMessageHelper.getKafkaCallback(authServiceConfigData.getUserCreateRequestTopicName(),
                                    userCreatedRequestAvroModel, userOutboxMessage, outboxCallback,
                                    sagaId, "UserCreateRequestAvroModel"));
                    break;
                case "DELETING":
                    UserRequestAvroModel userDeletedRequestAvroModel = userMessagingDataMapper
                            .userDeletedToUserDeleteRequestAvroModel(sagaId, userEventPayload);

                    kafkaProducer.send(authServiceConfigData.getUserDeleteRequestTopicName(),
                            sagaId,
                            userDeletedRequestAvroModel,
                            userKafkaMessageHelper.getKafkaCallback(authServiceConfigData.getUserDeleteRequestTopicName(),
                                    userDeletedRequestAvroModel, userOutboxMessage, outboxCallback,
                                    sagaId, "UserCreateRequestAvroModel"));
                    break;
                case "UPDATING":
                    UserRequestAvroModel userUpdatedRequestAvroModel = userMessagingDataMapper
                            .userUpdatedToUserUpdateRequestAvroModel(sagaId, userEventPayload);

                    kafkaProducer.send(authServiceConfigData.getUserUpdateRequestTopicName(),
                            sagaId,
                            userUpdatedRequestAvroModel,
                            userKafkaMessageHelper.getKafkaCallback(authServiceConfigData.getUserUpdateRequestTopicName(),
                                    userUpdatedRequestAvroModel, userOutboxMessage, outboxCallback,
                                    sagaId, "UserCreateRequestAvroModel"));
                    break;
            }
            log.info("UserRequestAvroModel sent to Kafka for user id: {} and saga id: {}", userEventPayload.getUserId(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending UserRequestAvroModel message" +
                    " to kafka with user id: {} and saga id: {}, error: {}", userEventPayload.getUserId(), sagaId, e.getMessage());
        }

    }

    private UserEventPayload getUserEventPayload(String payload) {
        try {
            return objectMapper.readValue(payload, UserEventPayload.class);
        } catch (JsonProcessingException e) {
            log.error("Could not read UserCreatedEventPayload object:", e);
            throw new AuthDomainException("Could not read UserCreatedEventPayload object: {}", e);
        }
    }
}
