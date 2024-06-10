package com.backend.programming.learning.system.auth.service.messaging.listener.kafka.user;

import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.user.UserRequestCourseToAuthMessageListener;
import com.backend.programming.learning.system.auth.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.domain.exception.user.UserNotFoundException;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.PSQLState;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserRequestCourseToAuthKafkaListener implements KafkaConsumer<UserRequestAvroModel> {
    private final UserRequestCourseToAuthMessageListener userRequestMessageListener;
    private final UserMessagingDataMapper userMessagingDataMapper;

    @Override
    @KafkaListener(id = "${kafka-consumer-config.course-service-user-response-to-auth-service-group-id}",
            topics = "${auth-service.course-service-user-request-to-auth-service-topic-name}")
    public void receive(@Payload List<UserRequestAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of user requests received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(userRequestAvroModel -> {
            try {
                switch (userRequestAvroModel.getCopyState()) {
                    case CREATING -> {
                        log.info("Creating user: {}",
                                userRequestAvroModel);
                        userRequestMessageListener
                                .userCreated(userMessagingDataMapper
                                        .userCreateRequestAvroModelToUserCreateRequest(userRequestAvroModel));
                    }
                    case DELETING -> {
                        log.info("Deleting user: {}",
                                userRequestAvroModel);
                        userRequestMessageListener
                                .userDeleted(userMessagingDataMapper
                                        .userDeleteRequestAvroModelToUserDeleteRequest(userRequestAvroModel));
                    }
                    case UPDATING -> {
                        log.info("Updating user: {}",
                                userRequestAvroModel);
                        userRequestMessageListener
                                .userUpdated(userMessagingDataMapper
                                        .userUpdateRequestAvroModelToUserUpdateRequest(userRequestAvroModel));
                    }
                }
            } catch (DataAccessException e) {
                SQLException sqlException = (SQLException) e.getRootCause();
                if (sqlException != null && sqlException.getSQLState() != null &&
                        PSQLState.UNIQUE_VIOLATION.getState().equals(sqlException.getSQLState())) {
                    //NO-OP for unique constraint exception
                    log.error("Caught unique constraint exception with sql state: {} " +
                                    "in UserRequestKafkaListener for user id: {}",
                            sqlException.getSQLState(), userRequestAvroModel.getUserId());
                } else {
                    throw new AuthDomainException("Throwing DataAccessException in" +
                            " UserRequestKafkaListener: " + e.getMessage(), e);
                }
            } catch (UserNotFoundException e) {
                //NO-OP for OrderNotFoundException
                log.error("No user found for user id: {}", userRequestAvroModel.getUserId());
            }
        });
    }
}
