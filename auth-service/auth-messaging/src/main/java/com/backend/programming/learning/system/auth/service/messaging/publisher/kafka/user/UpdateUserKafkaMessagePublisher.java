package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka.user;

import com.backend.programming.learning.system.auth.service.domain.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserUpdatedMessagePublisher;
import com.backend.programming.learning.system.auth.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdateUserKafkaMessagePublisher implements UserUpdatedMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final AuthServiceConfigData authServiceConfigData;
    private final KafkaProducer<String, UserUpdateRequestAvroModel> kafkaProducer;
    private final KafkaMessageHelper kafkaMessageHelper;

    public UpdateUserKafkaMessagePublisher(UserMessagingDataMapper userMessagingDataMapper, AuthServiceConfigData authServiceConfigData, KafkaProducer<String, UserUpdateRequestAvroModel> kafkaProducer, KafkaMessageHelper kafkaMessageHelper) {
        this.userMessagingDataMapper = userMessagingDataMapper;
        this.authServiceConfigData = authServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(UserUpdatedEvent domainEvent) {
        String userId = domainEvent.getUser().getId().getValue().toString();
        log.info("Received UserUpdatedEvent for user id: {}", userId);

        try {
            UserUpdateRequestAvroModel userUpdateRequestAvroModel = userMessagingDataMapper
                    .userUpdatedToUserUpdateRequestAvroModel(domainEvent);
            kafkaProducer.send(authServiceConfigData.getUserUpdateRequestTopicName(),
                    userId,
                    userUpdateRequestAvroModel,
                    kafkaMessageHelper.getKafkaCallback(authServiceConfigData.getUserResponseTopicName(),
                            userUpdateRequestAvroModel,
                            userId,
                            "UserUpdateRequestAvroModel"));
            log.info("UserUpdateRequestAvroModel sent to Kafka for user id: {}", userUpdateRequestAvroModel.getUserId());
        } catch (Exception e) {
            log.error("Error while sending UserUpdateRequestAvroModel message" +
                    " to kafka with user id: {}, error: {}", userId, e.getMessage());
        }
    }
}
