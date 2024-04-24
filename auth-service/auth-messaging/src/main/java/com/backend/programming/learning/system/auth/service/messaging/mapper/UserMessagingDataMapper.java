package com.backend.programming.learning.system.auth.service.messaging.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserUpdatedEvent;
import com.backend.programming.learning.system.domain.valueobject.UserResponseStatus;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserCreateRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserDeleteRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserResponseAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.user.UserUpdateRequestAvroModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMessagingDataMapper {
    public UserCreateRequestAvroModel userCreatedToUserCreateRequestAvroModel(UserCreatedEvent userCreatedEvent) {
        User user = userCreatedEvent.getUser();
        return UserCreateRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setUserId(user.getId().getValue().toString())
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPhone(user.getPhone())
                .setCreatedAt(user.getCreatedAt().toInstant())
                .setUpdatedAt(user.getUpdatedAt().toInstant())
                .setIsDeleted(user.getDeleted())
                .build();
    }

    public UserUpdateRequestAvroModel userUpdatedToUserUpdateRequestAvroModel(UserUpdatedEvent userUpdatedEvent) {
        User user = userUpdatedEvent.getUser();
        if (user.getDob() == null) {
            return UserUpdateRequestAvroModel.newBuilder()
                    .setId(UUID.randomUUID().toString())
                    .setSagaId("")
                    .setUserId(user.getId().getValue().toString())
                    .setFirstName(user.getFirstName())
                    .setLastName(user.getLastName())
                    .setPhone(user.getPhone())
                    .setAddress(user.getAddress())
                    .setAvatarUrl(user.getAvatarUrl())
                    .setUpdatedAt(user.getUpdatedAt().toInstant())
                    .build();
        }
        return UserUpdateRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setUserId(user.getId().getValue().toString())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPhone(user.getPhone())
                .setAddress(user.getAddress())
                .setDob(user.getDob().toInstant())
                .setAvatarUrl(user.getAvatarUrl())
                .setUpdatedAt(user.getUpdatedAt().toInstant())
                .build();
    }

    public UserDeleteRequestAvroModel userDeletedToUserDeleteRequestAvroModel(UserDeletedEvent userDeletedEvent) {
        User user = userDeletedEvent.getUser();
        return UserDeleteRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setUserId(user.getId().getValue().toString())
                .setIsDeleted(user.getDeleted())
                .build();
    }

    public UserResponse userResponseAvroModelToUserResponse(UserResponseAvroModel userResponseAvroModel) {
        return UserResponse.builder()
                .id(userResponseAvroModel.getId())
                .sagaId(userResponseAvroModel.getSagaId())
                .userId(userResponseAvroModel.getUserId())
                .userResponseStatus(UserResponseStatus.valueOf(userResponseAvroModel.getUserResponseStatus().name()))
                .failureMessages(userResponseAvroModel.getFailureMessages())
                .build();

    }
}
