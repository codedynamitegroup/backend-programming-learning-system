package com.backend.programming.learning.system.core.service.messaging.listener.kafka.user;

import com.backend.programming.learning.system.core.service.domain.exception.CoreApplicationServiceException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.user.UserRequestMessageListener;
import com.backend.programming.learning.system.core.service.messaging.mapper.UserMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.ServiceName;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
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
public class UserRequestKafkaListener implements KafkaConsumer<UserRequestAvroModel> {
    private final UserRequestMessageListener userRequestMessageListener;
    private final UserMessagingDataMapper userMessagingDataMapper;

    public UserRequestKafkaListener(UserRequestMessageListener userRequestMessageListener, UserMessagingDataMapper userMessagingDataMapper) {
        this.userRequestMessageListener = userRequestMessageListener;
        this.userMessagingDataMapper = userMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.core-service-user-request-group-id}",
            topics = "${core-service.core-user-request-topic-name}")
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
                    throw new CoreApplicationServiceException("Throwing DataAccessException in" +
                            " UserRequestKafkaListener: " + e.getMessage(), e);
                }
            } catch (UserNotFoundException e) {
                //NO-OP for OrderNotFoundException
                log.error("No user found for user id: {}", userRequestAvroModel.getUserId());
            }
        });
    }
}
