package com.backend.programming.learning.system.auth.service.messaging.listener.kafka.user;

import com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.CoreServiceUserResponseMessageListener;
import com.backend.programming.learning.system.auth.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserResponseAvroModel;
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
public class CoreServiceUserResponseKafkaListener implements KafkaConsumer<UserResponseAvroModel> {
    private final CoreServiceUserResponseMessageListener userResponseMessageListener;
    private final UserMessagingDataMapper userMessagingDataMapper;

    public CoreServiceUserResponseKafkaListener(CoreServiceUserResponseMessageListener userResponseMessageListener, UserMessagingDataMapper userMessagingDataMapper) {
        this.userResponseMessageListener = userResponseMessageListener;
        this.userMessagingDataMapper = userMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.core-service-user-response-group-id}",
            topics = "${auth-service.user-response-topic-name}")
    public void receive(@Payload List<UserResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of user responses received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(userResponseAvroModel -> {
            switch (userResponseAvroModel.getUserResponseStatus()){
                case CREATED:{
                    log.info("Success to create user for id: {}",
                            userResponseAvroModel.getUserId());
                    userResponseMessageListener
                            .userCreateSuccess(userMessagingDataMapper
                                    .userResponseAvroModelToUserResponse(userResponseAvroModel));
                    break;
                }
                case CREATE_FAILED:{
                    log.info("Fail to create user for id: {}",
                            userResponseAvroModel.getUserId());
                    userResponseMessageListener
                            .userCreateFail(userMessagingDataMapper
                                    .userResponseAvroModelToUserResponse(userResponseAvroModel));
                    break;
                }
                case DELETED: {
                    log.info("Success to delete user for id: {}",
                            userResponseAvroModel.getUserId());
                    userResponseMessageListener
                            .userDeleteSuccess(userMessagingDataMapper
                                    .userResponseAvroModelToUserResponse(userResponseAvroModel));
                    break;
                }
                case DELETE_FAILED:{
                    log.info("Fail to delete user for id: {}",
                            userResponseAvroModel.getUserId());
                    userResponseMessageListener
                            .userDeleteFail(userMessagingDataMapper
                                    .userResponseAvroModelToUserResponse(userResponseAvroModel));
                    break;
                }
                case UPDATED:{
                    log.info("Success to update user for id: {}",
                            userResponseAvroModel.getUserId());
                    userResponseMessageListener
                            .userUpdatedSuccess(userMessagingDataMapper
                                    .userResponseAvroModelToUserResponse(userResponseAvroModel));
                    break;
                }
                case UPDATE_FAILED:{
                    log.info("Fail to update user for id: {}",
                            userResponseAvroModel.getUserId());
                    userResponseMessageListener
                            .userUpdatedFail(userMessagingDataMapper
                                    .userResponseAvroModelToUserResponse(userResponseAvroModel));
                    break;
                }
            }

        });
    }
}
