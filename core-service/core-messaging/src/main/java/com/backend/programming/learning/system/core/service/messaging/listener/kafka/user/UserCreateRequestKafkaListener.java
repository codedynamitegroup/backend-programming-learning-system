package com.backend.programming.learning.system.core.service.messaging.listener.kafka.user;

import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.auth.UserRequestMessageListener;
import com.backend.programming.learning.system.core.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserCreateRequestAvroModel;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserCreateRequestKafkaListener implements KafkaConsumer<UserCreateRequestAvroModel> {
    private final UserRequestMessageListener userRequestMessageListener;
    private final UserMessagingDataMapper userMessagingDataMapper;

    public UserCreateRequestKafkaListener(UserRequestMessageListener userRequestMessageListener, UserMessagingDataMapper userMessagingDataMapper) {
        this.userRequestMessageListener = userRequestMessageListener;
        this.userMessagingDataMapper = userMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.core-service-user-create-request-group-id}",
            topics = "${core-service.user-create-request-topic-name}")
    public void receive(@Payload List<UserCreateRequestAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of user requests received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(userRequestAvroModel -> {
            log.info("Creating user: {}",
                    userRequestAvroModel);
            userRequestMessageListener
                    .userCreated(userMessagingDataMapper
                            .userCreateRequestAvroModelToUserCreateRequest(userRequestAvroModel));
        });
    }
}
