package com.backend.programming.learning.system.course.service.messaging.publisher.kafka.user;

import com.backend.programming.learning.system.course.service.config.CourseServiceConfigData;
import com.backend.programming.learning.system.course.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.course.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.user.UserRequestCourseToAuthMessagePublisher;
import com.backend.programming.learning.system.course.service.messaging.mapper.UserMessagingDataMapper;
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
public class UserRequestEventCourseToAuthKafkaPublisher implements UserRequestCourseToAuthMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final KafkaProducer<String, UserRequestAvroModel> kafkaProducer;
    private final CourseServiceConfigData courseServiceConfigData;
    private final KafkaOutboxMessageHelper kafkaOutboxMessageHelper;

    @Override
    public void publish(UserOutboxMessage userOutboxMessage, BiConsumer<UserOutboxMessage, OutboxStatus> outboxCallback) {
        UserEventPayload userEventPayload = kafkaOutboxMessageHelper.getEventPayload(userOutboxMessage.getPayload(), UserEventPayload.class);

        String sagaId = userOutboxMessage.getSagaId().toString();
        ServiceName serviceName = ServiceName.AUTH_SERVICE;

        String requestTopicName = courseServiceConfigData.getCourseServiceUserRequestToAuthServiceTopicName();
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
