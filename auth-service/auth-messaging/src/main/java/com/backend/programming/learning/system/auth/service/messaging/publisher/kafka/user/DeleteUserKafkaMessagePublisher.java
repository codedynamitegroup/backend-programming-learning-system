package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka.user;

import com.backend.programming.learning.system.auth.service.domain.config.AuthServiceConfigData;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserDeletedMessagePublisher;
import com.backend.programming.learning.system.auth.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserDeleteRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DeleteUserKafkaMessagePublisher implements UserDeletedMessagePublisher {
    private final UserMessagingDataMapper userMessagingDataMapper;
    private final AuthServiceConfigData authServiceConfigData;
    private final KafkaProducer<String, UserDeleteRequestAvroModel> kafkaProducer;
    private final KafkaMessageHelper userKafkaMessageHelper;

    public DeleteUserKafkaMessagePublisher(UserMessagingDataMapper userMessagingDataMapper, AuthServiceConfigData authServiceConfigData, KafkaProducer<String, UserDeleteRequestAvroModel> kafkaProducer, KafkaMessageHelper userKafkaMessageHelper) {
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
            UserDeleteRequestAvroModel userDeleteRequestAvroModel = userMessagingDataMapper
                    .userDeletedToUserDeleteRequestAvroModel(domainEvent);
            kafkaProducer.send(authServiceConfigData.getUserDeleteRequestTopicName(),
                    userId,
                    userDeleteRequestAvroModel,
                    userKafkaMessageHelper.getKafkaCallback(authServiceConfigData.getUserResponseTopicName(),
                            userDeleteRequestAvroModel,
                            userId,
                            "UserDeleteRequestAvroModel"));
            log.info("UserDeleteRequestAvroModel sent to Kafka for user id: {}", userDeleteRequestAvroModel.getUserId());
        } catch (Exception e) {
            log.error("Error while sending UserDeleteRequestAvroModel message" +
                    " to kafka with user id: {}, error: {}", userId, e.getMessage());
        }
    }
}
