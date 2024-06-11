package com.backend.programming.learning.system.course.service.messaging.listener.kafka.user;

import com.backend.programming.learning.system.course.service.domain.exception.CourseNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.user.UserResponseAuthServiceToCourseServiceMessageListener;
import com.backend.programming.learning.system.course.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserResponseAvroModel;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import jakarta.persistence.OptimisticLockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserResponseAuthToCourseServiceKafkaListener implements KafkaConsumer<UserResponseAvroModel> {
    private final UserResponseAuthServiceToCourseServiceMessageListener userResponseMessageListener;
    private final UserMessagingDataMapper userMessagingDataMapper;

    public UserResponseAuthToCourseServiceKafkaListener(UserResponseAuthServiceToCourseServiceMessageListener userResponseMessageListener, UserMessagingDataMapper userMessagingDataMapper) {
        this.userResponseMessageListener = userResponseMessageListener;
        this.userMessagingDataMapper = userMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.auth-service-to-course-service-user-response-group-id}",
            topics = "${course-service.auth-service-user-response-to-course-service-topic-name}")
    public void receive(@Payload List<UserResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of user responses received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(userResponseAvroModel -> {
            try {
                switch (userResponseAvroModel.getCopyState()) {
                    case CREATED, DELETED, UPDATED -> {
                        userResponseMessageListener
                                .userCreatedUpdatedSuccess(userMessagingDataMapper
                                        .userResponseAvroModelToUserResponse(userResponseAvroModel));
                    }
                    case CREATE_FAILED, DELETE_FAILED, UPDATE_FAILED -> {
                        userResponseMessageListener
                                .userCreatedUpdatedFail(userMessagingDataMapper
                                        .userResponseAvroModelToUserResponse(userResponseAvroModel));
                    }
                }
            } catch (OptimisticLockException e) {
                //NO-OP for optimistic lock. This means another thread finished the work, do not throw error to prevent reading the data from kafka again!
                log.error("Caught optimistic locking exception in UserResponseAvroModel for user id: {}",
                        userResponseAvroModel.getUserId());
            } catch (CourseNotFoundException e) {
                //NO-OP for OrderNotFoundException
                log.error("No user found for user id: {}", userResponseAvroModel.getUserId());
            }
        });
    }
}
