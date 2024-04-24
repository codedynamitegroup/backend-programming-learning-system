package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka.user;

import com.backend.programming.learning.system.auth.service.domain.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserCreatedMessagePublisher;
import com.backend.programming.learning.system.auth.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserCreateRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CreateUserKafkaMessagePublisher implements UserCreatedMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final AuthServiceConfigData authServiceConfigData;
    private final KafkaProducer<String, UserCreateRequestAvroModel> kafkaProducer;
    private final KafkaMessageHelper kafkaMessageHelper;

    public CreateUserKafkaMessagePublisher(UserMessagingDataMapper userMessagingDataMapper, AuthServiceConfigData authServiceConfigData, KafkaProducer<String, UserCreateRequestAvroModel> kafkaProducer, KafkaMessageHelper kafkaMessageHelper) {
        this.userMessagingDataMapper = userMessagingDataMapper;
        this.authServiceConfigData = authServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(UserCreatedEvent domainEvent) {
        String userId = domainEvent.getUser().getId().getValue().toString();
        log.info("Received UserCreatedEvent for user id: {}", userId);

        try {
            UserCreateRequestAvroModel userCreateRequestAvroModel = userMessagingDataMapper
                    .userCreatedToUserCreateRequestAvroModel(domainEvent);
            kafkaProducer.send(authServiceConfigData.getUserCreateRequestTopicName(),
                    userId,
                    userCreateRequestAvroModel,
                    kafkaMessageHelper.getKafkaCallback(authServiceConfigData.getUserResponseTopicName(),
                            userCreateRequestAvroModel, userId, "UserCreateRequestAvroModel"));
            log.info("UserCreateRequestAvroModel sent to Kafka for user id: {}", userCreateRequestAvroModel.getUserId());
        } catch (Exception e) {
            log.error("Error while sending UserCreateRequestAvroModel message" +
                    " to kafka with user id: {}, error: {}", userId, e.getMessage());
        }

    }
}
