package com.backend.programming.learning.system.course.service.messaging.mapper;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserRequest;
import com.backend.programming.learning.system.course.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.CopyState;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.ServiceName;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserResponseAvroModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
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
                        ServiceName.valueOf(com.backend.programming.learning.system.domain.valueobject.ServiceName.COURSE_SERVICE.name()))
                .setFailureMessages(Objects.isNull(userEventPayload.getFailureMessages()) ? List.of() : userEventPayload.getFailureMessages())
                .build();
    }

    public UserRequestAvroModel userCreatedEventPayloadToUserCreateRequestAvroModel(String sagaId,
                                                                                    com.backend.programming.learning.system.domain.valueobject.ServiceName serviceName,
                                                                                    UserEventPayload userEventPayload) {
        return UserRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId(sagaId)
                .setOrganizationId(userEventPayload.getOrganizationId())
                .setUserName(userEventPayload.getUserName())
                .setUserId(userEventPayload.getUserId())
                .setEmail(userEventPayload.getEmail())
                .setFirstName(userEventPayload.getFirstName())
                .setLastName(userEventPayload.getLastName())
                .setPhone(userEventPayload.getPhone())
                .setCreatedAt(userEventPayload.getCreatedAt().toInstant())
                .setUpdatedAt(userEventPayload.getUpdatedAt().toInstant())
                .setIsDeleted(userEventPayload.getIsDeleted())
                .setServiceName(ServiceName.valueOf(serviceName.name()))
                .setCopyState(CopyState.valueOf(userEventPayload.getCopyState()))
                .build();
    }

    public UserRequestAvroModel userUpdatedToUserUpdateRequestAvroModel(String sagaId, com.backend.programming.learning.system.domain.valueobject.ServiceName serviceName,
                                                                        UserEventPayload userEventPayload) {
        return UserRequestAvroModel.newBuilder()
                .setId(userEventPayload.getId())
                .setSagaId(sagaId)
                .setOrganizationId(userEventPayload.getOrganizationId())
                .setUserId(userEventPayload.getUserId())
                .setFirstName(userEventPayload.getFirstName())
                .setUserName(userEventPayload.getUserName())
                .setLastName(userEventPayload.getLastName())
                .setAddress(userEventPayload.getAddress())
                .setAvatarUrl(userEventPayload.getAvatarUrl())
                .setDob(userEventPayload.getDob().toInstant())
                .setPhone(userEventPayload.getPhone())
                .setUpdatedAt(userEventPayload.getUpdatedAt().toInstant())
                .build();
    }
}