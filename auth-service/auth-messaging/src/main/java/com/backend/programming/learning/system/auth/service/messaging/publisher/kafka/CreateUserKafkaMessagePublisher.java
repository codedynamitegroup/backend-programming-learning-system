package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka;

import com.backend.programming.learning.system.auth.service.domain.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.event.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserCreatedMessagePublisher;
import com.backend.programming.learning.system.auth.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CreateUserKafkaMessagePublisher implements UserCreatedMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final AuthServiceConfigData authServiceConfigData;
    private final KafkaProducer<String, UserRequestAvroModel> kafkaProducer;
    private final UserKafkaMessageHelper userKafkaMessageHelper;

    public CreateUserKafkaMessagePublisher(UserMessagingDataMapper userMessagingDataMapper, AuthServiceConfigData authServiceConfigData, KafkaProducer<String, UserRequestAvroModel> kafkaProducer, UserKafkaMessageHelper userKafkaMessageHelper) {
        this.userMessagingDataMapper = userMessagingDataMapper;
        this.authServiceConfigData = authServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.userKafkaMessageHelper = userKafkaMessageHelper;
    }

    @Override
    public void publish(UserCreatedEvent domainEvent) {
        String userId = domainEvent.getUser().getId().getValue().toString();
        log.info("Received UserCreatedEvent for user id: {}", userId);

        try {
            UserRequestAvroModel userRequestAvroModel = userMessagingDataMapper
                    .userCreatedToUserRequestAvroModel(domainEvent);
            kafkaProducer.send(authServiceConfigData.getUserRequestTopicName(),
                    userId,
                    userRequestAvroModel,
                    userKafkaMessageHelper.getKafkaCallback(authServiceConfigData.getUserResponseTopicName(),
                            userRequestAvroModel, userId, "UserRequestAvroModel"));
            log.info("UserRequestAvroModel sent to Kafka for user id: {}", userRequestAvroModel.getUserId());
        } catch (Exception e) {
            log.error("Error while sending UserRequestAvroModel message" +
                    " to kafka with user id: {}, error: {}", userId, e.getMessage());
        }

    }
}
