package com.backend.programming.learning.system.auth.service.messaging.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserResponseAvroModel;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.UUID;

@Component
public class UserMessagingDataMapper {
    public UserRequestAvroModel userUpdatedToUserUpdateRequestAvroModel(String sagaId,
                                                                        UserEventPayload userEventPayload) {
        Instant instantWithZeroNano = Instant.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS);
        Instant dob = userEventPayload.getDob().toInstant();
        if (userEventPayload.getDob() == null) {
            dob = instantWithZeroNano;
        }
        return UserRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setUserId(userEventPayload.getUserId())
                .setFirstName(userEventPayload.getFirstName())
                .setLastName(userEventPayload.getLastName())
                .setPhone(userEventPayload.getPhone())
                .setAddress(userEventPayload.getAddress())
                .setDob(dob)
                .setAvatarUrl(userEventPayload.getAvatarUrl())
                .setUpdatedAt(userEventPayload.getUpdatedAt().toInstant())
                .build();
    }

    public UserRequestAvroModel userDeletedToUserDeleteRequestAvroModel(String sagaId,
                                                                        UserEventPayload userEventPayload) {
        return UserRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId(sagaId)
                .setUserId(userEventPayload.getUserId())
                .setIsDeleted(userEventPayload.getIsDeleted())
                .build();
    }

    public UserResponse userResponseAvroModelToUserResponse(UserResponseAvroModel userResponseAvroModel) {
        return UserResponse.builder()
                .id(userResponseAvroModel.getId())
                .sagaId(userResponseAvroModel.getSagaId())
                .userId(userResponseAvroModel.getUserId())
                .state(CopyState.valueOf(userResponseAvroModel.getCopyState().name()))
                .failureMessages(userResponseAvroModel.getFailureMessages())
                .build();

    }

    public UserRequestAvroModel userCreatedEventPayloadToUserCreateRequestAvroModel(String sagaId,
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
                .build();
    }
}
