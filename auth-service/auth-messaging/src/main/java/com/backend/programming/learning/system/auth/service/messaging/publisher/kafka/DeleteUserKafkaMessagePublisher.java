package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka;

import com.backend.programming.learning.system.auth.service.domain.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.event.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserDeletedMessagePublisher;
import com.backend.programming.learning.system.auth.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DeleteUserKafkaMessagePublisher implements UserDeletedMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final AuthServiceConfigData authServiceConfigData;
    private final KafkaProducer<String, UserRequestAvroModel> kafkaProducer;
    private final KafkaMessageHelper userKafkaMessageHelper;

    public DeleteUserKafkaMessagePublisher(UserMessagingDataMapper userMessagingDataMapper, AuthServiceConfigData authServiceConfigData, KafkaProducer<String, UserRequestAvroModel> kafkaProducer, KafkaMessageHelper userKafkaMessageHelper) {
        this.userMessagingDataMapper = userMessagingDataMapper;
        this.authServiceConfigData = authServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.userKafkaMessageHelper = userKafkaMessageHelper;
    }

    @Override
    public void publish(UserDeletedEvent domainEvent) {
        String userId = domainEvent.getUser().getId().getValue().toString();
        log.info("Received UserDeletedEvent for user id: {}", userId);

        try {
            UserRequestAvroModel userRequestAvroModel = userMessagingDataMapper
                    .userDeletedToUserRequestAvroModel(domainEvent);
            kafkaProducer.send(authServiceConfigData.getUserRequestTopicName(),
                    userId,
                    userRequestAvroModel,
                    userKafkaMessageHelper.getKafkaCallback(authServiceConfigData.getUserResponseTopicName(),
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
