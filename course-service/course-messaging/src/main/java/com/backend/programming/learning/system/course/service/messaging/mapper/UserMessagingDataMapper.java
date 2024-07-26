package com.backend.programming.learning.system.course.service.messaging.mapper;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserResponse;
import com.backend.programming.learning.system.course.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class UserMessagingDataMapper {
    public UserRequest userCreateRequestAvroModelToUserCreateRequest(UserRequestAvroModel userCreateRequestAvroModel) {
        return UserRequest.builder()
                .id(userCreateRequestAvroModel.getId())
                .organizationId(userCreateRequestAvroModel.getOrganizationId())
                .userName(userCreateRequestAvroModel.getUsername())
                .sagaId(userCreateRequestAvroModel.getSagaId())
                .userId(userCreateRequestAvroModel.getUserId())
                .email(userCreateRequestAvroModel.getEmail())
                .firstName(userCreateRequestAvroModel.getFirstName())
                .lastName(userCreateRequestAvroModel.getLastName())
                .phone(userCreateRequestAvroModel.getPhone())
                .createdAt(userCreateRequestAvroModel.getCreatedAt())
                .updatedAt(userCreateRequestAvroModel.getUpdatedAt())
                .isDeleted(userCreateRequestAvroModel.getIsDeleted())
                .roleName(userCreateRequestAvroModel.getRoleName().name())
                .userIdMoodle(userCreateRequestAvroModel.getUserIdMoodle())
                .build();
    }

    public UserRequest userUpdateRequestAvroModelToUserUpdateRequest(UserRequestAvroModel userUpdateRequestAvroModel) {
        return UserRequest.builder()
                .id(userUpdateRequestAvroModel.getId())
                .organizationId(userUpdateRequestAvroModel.getOrganizationId())
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
                .setUsername(userEventPayload.getUserName())
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
                .setRoleName(RoleName.valueOf(userEventPayload.getRoleName()))
                .setUserIdMoodle(userEventPayload.getUserIdMoodle())
                .build();
    }

    public UserRequestAvroModel userUpdatedToUserUpdateRequestAvroModel(String sagaId, com.backend.programming.learning.system.domain.valueobject.ServiceName serviceName,
                                                                        UserEventPayload userEventPayload) {
        Instant instantWithZeroNano = Instant.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS);
        Instant dob;
        if (userEventPayload.getDob() == null) {
            dob = instantWithZeroNano;
        } else {
            dob = userEventPayload.getDob().toInstant();
        }
        return UserRequestAvroModel.newBuilder()
                .setId(userEventPayload.getId())
                .setSagaId(sagaId)
                .setOrganizationId(userEventPayload.getOrganizationId())
                .setUserId(userEventPayload.getUserId())
                .setFirstName(userEventPayload.getFirstName())
                .setUsername(userEventPayload.getUserName())
                .setLastName(userEventPayload.getLastName())
                .setAddress(userEventPayload.getAddress())
                .setAvatarUrl(userEventPayload.getAvatarUrl())
                .setDob(dob)
                .setPhone(userEventPayload.getPhone())
                .setUpdatedAt(userEventPayload.getUpdatedAt().toInstant())
                .setServiceName(ServiceName.valueOf(serviceName.name()))
                .setRoleName(RoleName.valueOf(userEventPayload.getRoleName()))
                .setCopyState(CopyState.valueOf(userEventPayload.getCopyState()))
                .build();
    }

    public UserResponse userResponseAvroModelToUserResponse(UserResponseAvroModel userResponseAvroModel) {
        return UserResponse.builder()
                .id(userResponseAvroModel.getId())
                .sagaId(userResponseAvroModel.getSagaId())
                .userId(userResponseAvroModel.getUserId())
                .state(com.backend.programming.learning.system.domain.valueobject
                        .CopyState.valueOf(userResponseAvroModel.getCopyState().name()))
                .failureMessages(userResponseAvroModel.getFailureMessages())
                .build();

    }
}