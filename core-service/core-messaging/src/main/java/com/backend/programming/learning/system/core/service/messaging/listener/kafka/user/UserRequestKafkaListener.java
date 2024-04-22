package com.backend.programming.learning.system.core.service.messaging.listener.kafka.user;

import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.auth.UserRequestMessageListener;
import com.backend.programming.learning.system.core.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserRequestStatus;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserResponseAvroModel;
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
public class UserRequestKafkaListener implements KafkaConsumer<UserRequestAvroModel> {
    private final UserRequestMessageListener userRequestMessageListener;
    private final UserMessagingDataMapper userMessagingDataMapper;

    public UserRequestKafkaListener(UserRequestMessageListener userRequestMessageListener, UserMessagingDataMapper userMessagingDataMapper) {
        this.userRequestMessageListener = userRequestMessageListener;
        this.userMessagingDataMapper = userMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.core-service-user-consumer-group-id}",
            topics = "${core-service.user-request-topic-name}")
    public void receive(@Payload List<UserRequestAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of user requests received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(userRequestAvroModel -> {
            switch (userRequestAvroModel.getUserRequestStatus()){
                case CREATING:{
                    log.info("Creating user for id: {}",
                            userRequestAvroModel.getUserId());
//                    userRequestMessageListener
//                            .userCreateSuccess(userMessagingDataMapper
//                                    .userRequestAvroModelToUserRequest(userRequestAvroModel));
                    break;
                }
                case UPDATING:{
                    log.info("Updating user for id: {}",
                            userRequestAvroModel.getUserId());
                    break;
                }
                case DELETING: {
                    log.info("Deleting user for id: {}",
                            userRequestAvroModel.getUserId());
                    break;
                }
            }

        });
    }
}
