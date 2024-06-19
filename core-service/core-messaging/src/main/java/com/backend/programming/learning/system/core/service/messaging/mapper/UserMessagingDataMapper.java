package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserRequest;
import com.backend.programming.learning.system.core.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMessagingDataMapper {
    public UserRequest userCreateRequestAvroModelToUserCreateRequest(UserRequestAvroModel userCreateRequestAvroModel) {
        return UserRequest.builder()
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

    public UserRequest userUpdateRequestAvroModelToUserUpdateRequest(UserRequestAvroModel userUpdateRequestAvroModel) {
        return UserRequest.builder()
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
                .isDeleted(userUpdateRequestAvroModel.getIsDeleted())
                .build();
    }

    public UserRequest userDeleteRequestAvroModelToUserDeleteRequest(UserRequestAvroModel userDeleteRequestAvroModel) {
        return UserRequest.builder()
                .id(userDeleteRequestAvroModel.getId())
                .sagaId(userDeleteRequestAvroModel.getSagaId())
                .userId(userDeleteRequestAvroModel.getUserId())
                .isDeleted(userDeleteRequestAvroModel.getIsDeleted())
                .build();
    }

    public UserResponseAvroModel userEventPayloadToUserResponseAvroModel(String sagaId, UserEventPayload userEventPayload) {
        return UserResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId(sagaId)
                .setUserId(userEventPayload.getUserId())
                .setCopyState(CopyState.valueOf(userEventPayload.getCopyState()))
                .setServiceName(
                        ServiceName.valueOf(com.backend.programming.learning.system.domain.valueobject.ServiceName.CORE_SERVICE.name()))
                .setFailureMessages(userEventPayload.getFailureMessages())
                .build();
    }
}