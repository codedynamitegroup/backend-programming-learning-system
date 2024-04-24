package com.backend.programming.learning.system.core.service.messaging.publisher.kafka.user;

import com.backend.programming.learning.system.core.service.domain.config.CoreServiceConfigData;
import com.backend.programming.learning.system.core.service.domain.event.user.UserCreatedFailEvent;
import com.backend.programming.learning.system.core.service.domain.event.user.UserUpdatedFailEvent;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.user.UserCreateFailedMessagePublisher;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.user.UserUpdateFailedMessagePublisher;
import com.backend.programming.learning.system.core.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserResponseAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdateFailedUserKafkaMessagePublisher implements UserUpdateFailedMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final CoreServiceConfigData coreServiceConfigData;
    private final KafkaProducer<String, UserResponseAvroModel> kafkaProducer;
    private final KafkaMessageHelper userKafkaMessageHelper;

    public UpdateFailedUserKafkaMessagePublisher(UserMessagingDataMapper userMessagingDataMapper, CoreServiceConfigData coreServiceConfigData, KafkaProducer<String, UserResponseAvroModel> kafkaProducer, KafkaMessageHelper userKafkaMessageHelper) {
        this.userMessagingDataMapper = userMessagingDataMapper;
        this.coreServiceConfigData = coreServiceConfigData;
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
            kafkaProducer.send(coreServiceConfigData.getUserResponseTopicName(),
                    userId,
                    userResponseAvroModel,
                    userKafkaMessageHelper.getKafkaCallback(coreServiceConfigData.getUserResponseTopicName(),
                            userResponseAvroModel, userId, "UserResponseAvroModel"));
            log.info("UserResponseAvroModel sent to Kafka for user id: {}", userResponseAvroModel.getUserId());
        } catch (Exception e) {
            log.error("Error while sending UserResponseAvroModel message" +
                    " to kafka with user id: {}, error: {}", userId, e.getMessage());
        }

    }
}
