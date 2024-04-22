package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka;

import com.backend.programming.learning.system.auth.service.domain.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.event.UserUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserUpdatedMessagePublisher;
import com.backend.programming.learning.system.auth.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdateUserKafkaMessagePublisher implements UserUpdatedMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final AuthServiceConfigData authServiceConfigData;
    private final KafkaProducer<String, UserRequestAvroModel> kafkaProducer;
    private final KafkaMessageHelper kafkaMessageHelper;

    public UpdateUserKafkaMessagePublisher(UserMessagingDataMapper userMessagingDataMapper, AuthServiceConfigData authServiceConfigData, KafkaProducer<String, UserRequestAvroModel> kafkaProducer, KafkaMessageHelper kafkaMessageHelper) {
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
            UserRequestAvroModel userRequestAvroModel = userMessagingDataMapper
                    .userUpdatedToUserRequestAvroModel(domainEvent);
            kafkaProducer.send(authServiceConfigData.getUserRequestTopicName(),
                    userId,
                    userRequestAvroModel,
                    kafkaMessageHelper.getKafkaCallback(authServiceConfigData.getUserResponseTopicName(),
                            userRequestAvroModel,
                            userId,
                            "UserRequestAvroModel"));
            log.info("UserRequestAvroModel sent to Kafka for user id: {}", userRequestAvroModel.getUserId());
        } catch (Exception e) {
            log.error("Error while sending UserRequestAvroModel message" +
                    " to kafka with user id: {}, error: {}", userId, e.getMessage());
        }
    }
}
