package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserCreateRequest;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserDeleteRequest;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserUpdateRequest;
import com.backend.programming.learning.system.core.service.domain.event.user.*;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class UserMessagingDataMapper {
    public UserResponseAvroModel userCreatedSuccessEventToUserResponseAvroModel(UserCreatedSuccessEvent userCreatedSuccessEvent) {
        return UserResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setUserId(userCreatedSuccessEvent.getUser().getId().getValue().toString())
                .setUserResponseStatus(UserResponseStatus.CREATED)
                .setFailureMessages(userCreatedSuccessEvent.getFailureMessages())
                .build();
    }
    public UserResponseAvroModel userCreatedFailEventToUserResponseAvroModel(UserCreatedFailEvent userCreatedFailEvent) {
        return UserResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setUserId(userCreatedFailEvent.getUser().getId().getValue().toString())
                .setUserResponseStatus(UserResponseStatus.CREATE_FAILED)
                .setFailureMessages(userCreatedFailEvent.getFailureMessages())
                .build();
    }

    public UserCreateRequest userCreateRequestAvroModelToUserCreateRequest(UserCreateRequestAvroModel userCreateRequestAvroModel) {
        return UserCreateRequest.builder()
                .id(userCreateRequestAvroModel.getId())
                .sagaId(userCreateRequestAvroModel.getSagaId())
                .userId(userCreateRequestAvroModel.getUserId())
                .email(userCreateRequestAvroModel.getEmail())
                .firstName(userCreateRequestAvroModel.getFirstName())
                .lastName(userCreateRequestAvroModel.getLastName())
                .phone(userCreateRequestAvroModel.getPhone())
                .createdAt(userCreateRequestAvroModel.getCreatedAt())
                .updatedAt(userCreateRequestAvroModel.getUpdatedAt())
                .isDeleted(userCreateRequestAvroModel.getIsDeleted())
                .build();
    }

    public UserUpdateRequest userUpdateRequestAvroModelToUserUpdateRequest(UserUpdateRequestAvroModel userUpdateRequestAvroModel) {
        return UserUpdateRequest.builder()
                .id(userUpdateRequestAvroModel.getId())
                .sagaId(userUpdateRequestAvroModel.getSagaId())
                .userId(userUpdateRequestAvroModel.getUserId())
                .firstName(userUpdateRequestAvroModel.getFirstName())
                .lastName(userUpdateRequestAvroModel.getLastName())
                .address(userUpdateRequestAvroModel.getAddress())
                .avatarUrl(userUpdateRequestAvroModel.getAvatarUrl())
                .dob(userUpdateRequestAvroModel.getDob())
                .phone(userUpdateRequestAvroModel.getPhone())
                .updatedAt(userUpdateRequestAvroModel.getUpdatedAt())
                .build();
    }

    public UserDeleteRequest userDeleteRequestAvroModelToUserDeleteRequest(UserDeleteRequestAvroModel userDeleteRequestAvroModel) {
        return UserDeleteRequest.builder()
                .id(userDeleteRequestAvroModel.getId())
                .sagaId(userDeleteRequestAvroModel.getSagaId())
                .userId(userDeleteRequestAvroModel.getUserId())
                .isDeleted(userDeleteRequestAvroModel.getIsDeleted())
                .build();
    }

    public UserResponseAvroModel userDeletedSuccessEventToUserResponseAvroModel(UserDeletedSuccessEvent domainEvent) {
        return UserResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setUserId(domainEvent.getUser().getId().getValue().toString())
                .setUserResponseStatus(UserResponseStatus.DELETED)
                .setFailureMessages(domainEvent.getFailureMessages())
                .build();
    }

    public UserResponseAvroModel userDeleteFailedEventToUserResponseAvroModel(UserDeletedFailEvent domainEvent) {
        return UserResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setUserId(domainEvent.getUser().getId().getValue().toString())
                .setUserResponseStatus(UserResponseStatus.DELETE_FAILED)
                .setFailureMessages(domainEvent.getFailureMessages())
                .build();
    }

    public UserResponseAvroModel userUpdatedSuccessEventToUserResponseAvroModel(UserUpdatedSuccessEvent domainEvent) {
        return UserResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setUserId(domainEvent.getUser().getId().getValue().toString())
                .setUserResponseStatus(UserResponseStatus.UPDATED)
                .setFailureMessages(domainEvent.getFailureMessages())
                .build();
    }

    public UserResponseAvroModel userUpdateFailedEventToUserResponseAvroModel(UserUpdatedFailEvent domainEvent) {
        return UserResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setUserId(domainEvent.getUser().getId().getValue().toString())
                .setUserResponseStatus(UserResponseStatus.UPDATE_FAILED)
                .setFailureMessages(domainEvent.getFailureMessages())
                .build();
    }
}
