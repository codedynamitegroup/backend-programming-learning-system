package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.UserRequest;
import com.backend.programming.learning.system.core.service.domain.event.user.UserCreatedFailEvent;
import com.backend.programming.learning.system.core.service.domain.event.user.UserCreatedSuccessEvent;
import com.backend.programming.learning.system.domain.valueobject.UserRequestStatus;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserResponseAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserResponseStatus;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMessagingDataMapper {
    public UserResponseAvroModel userCreatedSuccessEventToUserResponseAvroModel(UserCreatedSuccessEvent userCreatedSuccessEvent) {
        return UserResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setUserId(userCreatedSuccessEvent.getUser().getId().getValue().toString())
                .setEmail(userCreatedSuccessEvent.getUser().getEmail())
                .setFirstName(userCreatedSuccessEvent.getUser().getFirstName())
                .setLastName(userCreatedSuccessEvent.getUser().getLastName())
                .setCreatedAt(userCreatedSuccessEvent.getUser().getCreatedAt().toInstant())
                .setUpdatedAt(userCreatedSuccessEvent.getUser().getUpdatedAt().toInstant())
                .setUserResponseStatus(UserResponseStatus.CREATED)
                .setFailureMessages(userCreatedSuccessEvent.getFailureMessages())
                .build();
    }
    public UserResponseAvroModel userCreatedFailEventToUserResponseAvroModel(UserCreatedFailEvent userCreatedFailEvent) {
        return UserResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString().toString())
                .setSagaId("")
                .setUserId(userCreatedFailEvent.getUser().getId().getValue().toString())
                .setEmail(userCreatedFailEvent.getUser().getEmail())
                .setFirstName(userCreatedFailEvent.getUser().getFirstName())
                .setLastName(userCreatedFailEvent.getUser().getLastName())
                .setCreatedAt(userCreatedFailEvent.getUser().getCreatedAt().toInstant())
                .setUpdatedAt(userCreatedFailEvent.getUser().getUpdatedAt().toInstant())
                .setUserResponseStatus(UserResponseStatus.CREATE_FAILED)
                .setFailureMessages(userCreatedFailEvent.getFailureMessages())
                .build();
    }

    public UserRequest userRequestAvroModelToUserRequest(UserRequestAvroModel userRequestAvroModel) {
        return UserRequest.builder()
                .id(userRequestAvroModel.getId().toString())
                .sagaId(userRequestAvroModel.getSagaId().toString())
                .userId(userRequestAvroModel.getUserId().toString())
                .email(userRequestAvroModel.getEmail())
                .firstName(userRequestAvroModel.getFirstName())
                .lastName(userRequestAvroModel.getLastName())
                .phone(userRequestAvroModel.getPhone())
                .address(userRequestAvroModel.getAddress())
                .avatarUrl(userRequestAvroModel.getAvatarUrl())
                .dob(userRequestAvroModel.getDob())
                .createdAt(userRequestAvroModel.getCreatedAt())
                .updatedAt(userRequestAvroModel.getUpdatedAt())
                .userRequestStatus(UserRequestStatus.valueOf(userRequestAvroModel.getUserRequestStatus().name()))
                .build();
    }
}
