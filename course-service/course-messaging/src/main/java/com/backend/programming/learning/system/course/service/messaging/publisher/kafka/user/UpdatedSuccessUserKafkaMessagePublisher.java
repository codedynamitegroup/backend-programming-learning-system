package com.backend.programming.learning.system.course.service.messaging.publisher.kafka.user;

import com.backend.programming.learning.system.course.service.domain.config.CourseServiceConfigData;
import com.backend.programming.learning.system.course.service.domain.event.user.UserUpdatedSuccessEvent;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.user.UserUpdatedSuccessMessagePublisher;
import com.backend.programming.learning.system.course.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserResponseAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdatedSuccessUserKafkaMessagePublisher implements UserUpdatedSuccessMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final CourseServiceConfigData courseServiceConfigData;
    private final KafkaProducer<String, UserResponseAvroModel> kafkaProducer;
    private final KafkaMessageHelper userKafkaMessageHelper;

    public UpdatedSuccessUserKafkaMessagePublisher(UserMessagingDataMapper userMessagingDataMapper, CourseServiceConfigData courseServiceConfigData, KafkaProducer<String, UserResponseAvroModel> kafkaProducer, KafkaMessageHelper userKafkaMessageHelper) {
        this.userMessagingDataMapper = userMessagingDataMapper;
        this.courseServiceConfigData = courseServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.userKafkaMessageHelper = userKafkaMessageHelper;
    }

    @Override
    public void publish(UserUpdatedSuccessEvent domainEvent) {
        String userId = domainEvent.getUser().getId().getValue().toString();
        log.info("Received UserCreatedSuccessEvent for user id: {}", userId);

        try {
            UserResponseAvroModel userResponseAvroModel = userMessagingDataMapper
                    .userUpdatedSuccessEventToUserResponseAvroModel(domainEvent);
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
