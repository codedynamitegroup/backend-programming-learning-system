package com.backend.programming.learning.system.course.service.messaging.publisher.kafka.user;

import com.backend.programming.learning.system.course.service.config.CourseServiceConfigData;
import com.backend.programming.learning.system.course.service.domain.event.user.UserUpdatedFailEvent;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.user.UserUpdateFailedMessagePublisher;
import com.backend.programming.learning.system.course.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserResponseAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdateFailedUserKafkaMessagePublisher implements UserUpdateFailedMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final CourseServiceConfigData courseServiceConfigData;
    private final KafkaProducer<String, UserResponseAvroModel> kafkaProducer;
    private final KafkaMessageHelper userKafkaMessageHelper;

    public UpdateFailedUserKafkaMessagePublisher(UserMessagingDataMapper userMessagingDataMapper, CourseServiceConfigData courseServiceConfigData, KafkaProducer<String, UserResponseAvroModel> kafkaProducer, KafkaMessageHelper userKafkaMessageHelper) {
        this.userMessagingDataMapper = userMessagingDataMapper;
        this.courseServiceConfigData = courseServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.userKafkaMessageHelper = userKafkaMessageHelper;
    }

    @Override
    public void publish(UserUpdatedFailEvent domainEvent) {
        String userId = domainEvent.getUser().getId().getValue().toString();
        log.info("Received UserCreateFailedEvent for user id: {}", userId);

        try {
            UserResponseAvroModel userResponseAvroModel = userMessagingDataMapper
                    .userUpdateFailedEventToUserResponseAvroModel(domainEvent);
            kafkaProducer.send(courseServiceConfigData.getUserResponseTopicName(),
                    userId,
                    userResponseAvroModel,
                    userKafkaMessageHelper.getKafkaCallback(courseServiceConfigData.getUserResponseTopicName(),
                            userResponseAvroModel, userId, "UserResponseAvroModel"));
            log.info("UserResponseAvroModel sent to Kafka for user id: {}", userResponseAvroModel.getUserId());
        } catch (Exception e) {
            log.error("Error while sending UserResponseAvroModel message" +
                    " to kafka with user id: {}, error: {}", userId, e.getMessage());
        }

    }
}
