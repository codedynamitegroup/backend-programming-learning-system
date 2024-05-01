package com.backend.programming.learning.system.course.service.messaging.listener.kafka.user;

import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.auth.UserRequestMessageListener;
import com.backend.programming.learning.system.course.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserRequestAvroModel;
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
public class UserDeleteRequestKafkaListener implements KafkaConsumer<UserRequestAvroModel> {
    private final UserRequestMessageListener userRequestMessageListener;
    private final UserMessagingDataMapper userMessagingDataMapper;

    public UserDeleteRequestKafkaListener(UserRequestMessageListener userRequestMessageListener, UserMessagingDataMapper userMessagingDataMapper) {
        this.userRequestMessageListener = userRequestMessageListener;
        this.userMessagingDataMapper = userMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.course-service-user-delete-request-group-id}",
            topics = "${course-service.user-delete-request-topic-name}")
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
            log.info("Deleting user: {}",
                    userRequestAvroModel);
            userRequestMessageListener
                    .userDeleted(userMessagingDataMapper
                            .userDeleteRequestAvroModelToUserDeleteRequest(userRequestAvroModel));
        });
    }
}
