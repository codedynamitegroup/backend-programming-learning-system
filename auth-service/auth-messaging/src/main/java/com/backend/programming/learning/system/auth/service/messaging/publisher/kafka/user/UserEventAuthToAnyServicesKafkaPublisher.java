package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka.user;

import com.backend.programming.learning.system.auth.service.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_auth_to_any_services.UserEventAuthToAnyServicesPayload;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_auth_to_any_services.UserOutboxAuthToAnyServicesMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserRequestAuthToAnyServicesMessagePublisher;
import com.backend.programming.learning.system.auth.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserRequestAvroModel;
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
public class UserEventAuthToAnyServicesKafkaPublisher implements UserRequestAuthToAnyServicesMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final KafkaProducer<String, UserRequestAvroModel> kafkaProducer;
    private final AuthServiceConfigData authServiceConfigData;
    private final KafkaOutboxMessageHelper kafkaOutboxMessageHelper;

    @Override
    public void publish(UserOutboxAuthToAnyServicesMessage userOutboxMessage, BiConsumer<UserOutboxAuthToAnyServicesMessage, OutboxStatus> outboxCallback) {
        UserEventAuthToAnyServicesPayload userEventPayload = kafkaOutboxMessageHelper.getEventPayload(userOutboxMessage.getPayload(), UserEventAuthToAnyServicesPayload.class);

        String sagaId = userOutboxMessage.getSagaId().toString();
        ServiceName serviceName = userOutboxMessage.getServiceName();
        String requestTopicName;
        if (serviceName.equals(ServiceName.CORE_SERVICE)) {
            requestTopicName = authServiceConfigData.getAuthServiceUserRequestToCoreServiceTopicName();
        } else if (serviceName.equals(ServiceName.COURSE_SERVICE)){
            requestTopicName = authServiceConfigData.getAuthServiceUserRequestToCourseServiceTopicName();
        } else if (serviceName.equals(ServiceName.CODE_ASSESSMENT_SERVICE)) {
            requestTopicName = authServiceConfigData.getAuthServiceUserRequestToCodeAssessmentServiceTopicName();
        } else {
            return;
        }
        log.info("Received UserOutboxMessage for user id: {} and saga id: {}", userEventPayload.getUserId(), sagaId);

        try {
            switch (userOutboxMessage.getCopyState()) {
                case CREATING -> {
                    UserRequestAvroModel userRequestAvroModel = userMessagingDataMapper
                            .userCreatedEventPayloadToUserCreateRequestAvroModel(sagaId, serviceName, userEventPayload);
                    kafkaProducer.send(requestTopicName,
                            sagaId,
                            userRequestAvroModel,
                            kafkaOutboxMessageHelper.getKafkaCallback(requestTopicName,
                                    userRequestAvroModel, userOutboxMessage, outboxCallback,
                                    sagaId, "UserRequestAvroModel"));
                }
                case DELETING -> {
                    UserRequestAvroModel userRequestAvroModel = userMessagingDataMapper
                            .userDeletedToUserDeleteRequestAvroModel(sagaId, serviceName, userEventPayload);
                    kafkaProducer.send(requestTopicName,
                            sagaId,
                            userRequestAvroModel,
                            kafkaOutboxMessageHelper.getKafkaCallback(requestTopicName,
                                    userRequestAvroModel, userOutboxMessage, outboxCallback,
                                    sagaId, "UserRequestAvroModel"));
                }
                case UPDATING -> {
                    UserRequestAvroModel userRequestAvroModel = userMessagingDataMapper
                            .userUpdatedToUserUpdateRequestAvroModel(sagaId, serviceName, userEventPayload);
                    kafkaProducer.send(requestTopicName,
                            sagaId,
                            userRequestAvroModel,
                            kafkaOutboxMessageHelper.getKafkaCallback(requestTopicName,
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