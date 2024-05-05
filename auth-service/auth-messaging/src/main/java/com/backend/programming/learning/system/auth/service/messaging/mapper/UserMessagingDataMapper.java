package com.backend.programming.learning.system.auth.service.messaging.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.CopyState;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserResponseAvroModel;
import org.springframework.stereotype.Component;
import java.time.Instant;
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
                .setUserId(userEventPayload.getUserId())
                .setEmail(userEventPayload.getEmail())
                .setFirstName(userEventPayload.getFirstName())
                .setLastName(userEventPayload.getLastName())
                .setPhone(userEventPayload.getPhone())
                .setCreatedAt(userEventPayload.getCreatedAt().toInstant())
                .setUpdatedAt(userEventPayload.getUpdatedAt().toInstant())
                .setIsDeleted(userEventPayload.getIsDeleted())
                .setCopyState(CopyState.CREATING)
                .setServiceName(
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
}
