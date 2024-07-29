package com.backend.programming.learning.system.auth.service.messaging.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.user.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.message.user.UserRequest;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.CopyState;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserResponseAvroModel;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Component
public class UserMessagingDataMapper {
    public UserRequestAvroModel userUpdatedToUserUpdateRequestAvroModel(String sagaId,
                                                                        ServiceName serviceName,
                                                                        UserEventPayload userEventPayload) {
        Instant instantWithZeroNano = Instant.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS);
        Instant dob;
        if (userEventPayload.getDob() == null) {
            dob = instantWithZeroNano;
        } else {
            dob = userEventPayload.getDob().toInstant();
        }
        return UserRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId(sagaId)
                .setUserId(userEventPayload.getUserId())
                .setFirstName(userEventPayload.getFirstName())
                .setLastName(userEventPayload.getLastName())
                .setPhone(userEventPayload.getPhone())
                .setAddress(userEventPayload.getAddress())
                .setDob(dob)
                .setAvatarUrl(userEventPayload.getAvatarUrl())
                .setUpdatedAt(userEventPayload.getUpdatedAt().toInstant())
                .setCopyState(CopyState.UPDATING)
                .setRoleName(com.backend.programming.learning.system.kafka.auth.avro.model.user.RoleName.valueOf(userEventPayload.getRoleName()))
                .setServiceName(
                        com.backend.programming.learning.system.kafka.auth.avro.model.user.ServiceName.valueOf(serviceName.name()))
                .build();
    }

    public UserRequestAvroModel userDeletedToUserDeleteRequestAvroModel(String sagaId,
                                                                        ServiceName serviceName,
                                                                        UserEventPayload userEventPayload) {
        return UserRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId(sagaId)
                .setUserId(userEventPayload.getUserId())
                .setIsDeleted(userEventPayload.getIsDeleted())
                .setCopyState(CopyState.DELETING)
                .setServiceName(
                        com.backend.programming.learning.system.kafka.auth.avro.model.user.ServiceName.valueOf(serviceName.name()))
                .build();
    }

    public UserRequestAvroModel userCreatedEventPayloadToUserCreateRequestAvroModel(String sagaId,
                                                                                    ServiceName serviceName,
                                                                                    UserEventPayload userEventPayload)
    {
        return UserRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId(sagaId)
                .setUsername(userEventPayload.getUsername())
                .setOrganizationId(userEventPayload.getOrganizationId())
                .setUserId(userEventPayload.getUserId())
                .setEmail(userEventPayload.getEmail())
                .setFirstName(userEventPayload.getFirstName())
                .setLastName(userEventPayload.getLastName())
                .setPhone(userEventPayload.getPhone())
                .setCreatedAt(userEventPayload.getCreatedAt().toInstant())
                .setUpdatedAt(userEventPayload.getUpdatedAt().toInstant())
                .setIsDeleted(userEventPayload.getIsDeleted())
                .setCopyState(CopyState.CREATING)
                .setRoleName(userEventPayload.getRoleName() == null ? null :
                        com.backend.programming.learning.system.kafka.auth.avro.model.user.RoleName.valueOf(userEventPayload.getRoleName()))
                .setUserIdMoodle(userEventPayload.getUserIdMoodle())
                .setServiceName(serviceName == null ? null :
                        com.backend.programming.learning.system.kafka.auth.avro.model.user.ServiceName.valueOf(serviceName.name()))
                .build();
    }

    public UserResponse userResponseAvroModelToUserResponse(UserResponseAvroModel userResponseAvroModel) {
        return UserResponse.builder()
                .id(userResponseAvroModel.getId())
                .sagaId(userResponseAvroModel.getSagaId())
                .userId(userResponseAvroModel.getUserId())
                .state(com.backend.programming.learning.system.domain.valueobject
                        .CopyState.valueOf(userResponseAvroModel.getCopyState().name()))
                .serviceName(com.backend.programming.learning.system.domain.valueobject
                        .ServiceName.valueOf(userResponseAvroModel.getServiceName().name()))
                .failureMessages(userResponseAvroModel.getFailureMessages())
                .build();

    }

    public UserRequest userCreateRequestAvroModelToUserCreateRequest(UserRequestAvroModel userCreateRequestAvroModel) {
        return UserRequest.builder()
                .id(userCreateRequestAvroModel.getId())
                .sagaId(userCreateRequestAvroModel.getSagaId())
                .userId(userCreateRequestAvroModel.getUserId())
                .username(userCreateRequestAvroModel.getUsername())
                .organizationId(UUID.fromString(userCreateRequestAvroModel.getOrganizationId()))
                .email(userCreateRequestAvroModel.getEmail())
                .password("")
                .firstName(userCreateRequestAvroModel.getFirstName())
                .lastName(userCreateRequestAvroModel.getLastName())
                .phone(userCreateRequestAvroModel.getPhone())
                .createdAt(userCreateRequestAvroModel.getCreatedAt())
                .updatedAt(userCreateRequestAvroModel.getUpdatedAt())
                .isDeleted(userCreateRequestAvroModel.getIsDeleted())
                .userIdMoodle(userCreateRequestAvroModel.getUserIdMoodle())
                .roleName(com.backend.programming.learning.system.domain.valueobject.RoleName.valueOf(userCreateRequestAvroModel.getRoleName().name()))
                .copyState(com.backend.programming.learning.system.domain.valueobject.CopyState.CREATING)
                .serviceName(com.backend.programming.learning.system.domain.valueobject.ServiceName.valueOf(userCreateRequestAvroModel.getServiceName().name()))
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

    public UserRequest userUpdateRequestAvroModelToUserUpdateRequest(UserRequestAvroModel userUpdateRequestAvroModel) {
        return UserRequest.builder()
                .id(userUpdateRequestAvroModel.getId())
                .sagaId(userUpdateRequestAvroModel.getSagaId())
                .userId(userUpdateRequestAvroModel.getUserId())
                .username(userUpdateRequestAvroModel.getUsername())
                .organizationId(UUID.fromString(userUpdateRequestAvroModel.getOrganizationId()))
                .firstName(userUpdateRequestAvroModel.getFirstName())
                .lastName(userUpdateRequestAvroModel.getLastName())
                .address(userUpdateRequestAvroModel.getAddress())
                .avatarUrl(userUpdateRequestAvroModel.getAvatarUrl())
                .dob(userUpdateRequestAvroModel.getDob())
                .phone(userUpdateRequestAvroModel.getPhone())
                .updatedAt(userUpdateRequestAvroModel.getUpdatedAt())
                .isDeleted(userUpdateRequestAvroModel.getIsDeleted())
                .roleName(com.backend.programming.learning.system.domain.valueobject.RoleName.valueOf(userUpdateRequestAvroModel.getRoleName().name()))
                .serviceName(com.backend.programming.learning.system.domain.valueobject.ServiceName.valueOf(userUpdateRequestAvroModel.getServiceName().name()))
                .build();
    }

    public UserResponseAvroModel userEventCourseToAuthServicePayloadToUserResponseAvroModel(String sagaId, UserEventPayload userEventPayload) {
        return UserResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId(sagaId)
                .setUserId(userEventPayload.getUserId())
                .setCopyState(CopyState.valueOf(userEventPayload.getCopyState()))
                .setServiceName(
                        com.backend.programming.learning.system.kafka.auth.avro.model.user.ServiceName.valueOf(com.backend.programming.learning.system.domain.valueobject.ServiceName.COURSE_SERVICE.name()))
                .setFailureMessages(List.of())
                .build();
    }
}
