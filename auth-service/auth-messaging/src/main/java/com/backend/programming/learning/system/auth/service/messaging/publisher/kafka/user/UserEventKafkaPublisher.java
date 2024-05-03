package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka.user;

import com.backend.programming.learning.system.auth.service.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserRequestMessagePublisher;
import com.backend.programming.learning.system.auth.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaOutboxMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class UserEventKafkaPublisher implements UserRequestMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final KafkaProducer<String, UserRequestAvroModel> kafkaProducer;
    private final AuthServiceConfigData authServiceConfigData;
    private final KafkaOutboxMessageHelper kafkaOutboxMessageHelper;

    public UserEventKafkaPublisher(UserMessagingDataMapper userMessagingDataMapper, KafkaProducer<String, UserRequestAvroModel> kafkaProducer, AuthServiceConfigData authServiceConfigData, KafkaOutboxMessageHelper kafkaOutboxMessageHelper) {
        this.userMessagingDataMapper = userMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.authServiceConfigData = authServiceConfigData;
        this.kafkaOutboxMessageHelper = kafkaOutboxMessageHelper;
    }


    @Override
    public void publish(UserOutboxMessage userOutboxMessage, BiConsumer<UserOutboxMessage, OutboxStatus> outboxCallback) {
        UserEventPayload userEventPayload = kafkaOutboxMessageHelper.getEventPayload(userOutboxMessage.getPayload(), UserEventPayload.class);

        String sagaId = userOutboxMessage.getSagaId().toString();
        ServiceName serviceName = userOutboxMessage.getServiceName();

        log.info("Received UserOutboxMessage for user id: {} and saga id: {}", userEventPayload.getUserId(), sagaId);

        try {
            switch (userOutboxMessage.getCopyState()) {
                case CREATING -> {
                    UserRequestAvroModel userRequestAvroModel = userMessagingDataMapper
                            .userCreatedEventPayloadToUserCreateRequestAvroModel(sagaId, serviceName, userEventPayload);
                    kafkaProducer.send(authServiceConfigData.getUserRequestTopicName(),
                            sagaId,
                            userRequestAvroModel,
                            kafkaOutboxMessageHelper.getKafkaCallback(authServiceConfigData.getUserRequestTopicName(),
                                    userRequestAvroModel, userOutboxMessage, outboxCallback,
                                    sagaId, "UserRequestAvroModel"));
                }
                case DELETING -> {
                    UserRequestAvroModel userRequestAvroModel = userMessagingDataMapper
                            .userDeletedToUserDeleteRequestAvroModel(sagaId, serviceName, userEventPayload);
                    kafkaProducer.send(authServiceConfigData.getUserRequestTopicName(),
                            sagaId,
                            userRequestAvroModel,
                            kafkaOutboxMessageHelper.getKafkaCallback(authServiceConfigData.getUserRequestTopicName(),
                                    userRequestAvroModel, userOutboxMessage, outboxCallback,
                                    sagaId, "UserRequestAvroModel"));
                }
                case UPDATING -> {
                    UserRequestAvroModel userRequestAvroModel = userMessagingDataMapper
                            .userUpdatedToUserUpdateRequestAvroModel(sagaId, serviceName, userEventPayload);
                    kafkaProducer.send(authServiceConfigData.getUserRequestTopicName(),
                            sagaId,
                            userRequestAvroModel,
                            kafkaOutboxMessageHelper.getKafkaCallback(authServiceConfigData.getUserRequestTopicName(),
                                    userRequestAvroModel, userOutboxMessage, outboxCallback,
                                    sagaId, "UserRequestAvroModel"));
                }
            }
            log.info("UserRequestAvroModel sent to Kafka for user id: {} and saga id: {}", userEventPayload.getUserId(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending UserRequestAvroModel message" +
                    " to kafka with user id: {} and saga id: {}, error: {}", userEventPayload.getUserId(), sagaId, e.getMessage());
        }
    }
}
