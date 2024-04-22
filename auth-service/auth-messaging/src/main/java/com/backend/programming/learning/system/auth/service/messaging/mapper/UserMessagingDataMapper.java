package com.backend.programming.learning.system.auth.service.messaging.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.UserUpdatedEvent;
import com.backend.programming.learning.system.domain.valueobject.UserResponseStatus;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserRequestStatus;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserResponseAvroModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMessagingDataMapper {
    public UserRequestAvroModel userCreatedToUserRequestAvroModel(UserCreatedEvent userCreatedEvent) {
        User user = userCreatedEvent.getUser();
        return UserRequestAvroModel.newBuilder()
                .setId(UUID.fromString(UUID.randomUUID().toString()))
                .setSagaId(UUID.fromString(""))
                .setUserId(UUID.fromString(user.getId().getValue().toString()))
                .setEmail(user.getEmail())
                .setPhone(user.getPhone())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setCreatedAt(user.getCreatedAt().toInstant())
                .setIsDeleted(user.getDeleted())
                .setUserRequestStatus(UserRequestStatus.CREATING)
                .build();
    }

    public UserRequestAvroModel userUpdatedToUserRequestAvroModel(UserUpdatedEvent userUpdatedEvent) {
        User user = userUpdatedEvent.getUser();
        return UserRequestAvroModel.newBuilder()
                .setId(UUID.fromString(UUID.randomUUID().toString()))
                .setSagaId(UUID.fromString(""))
                .setUserId(UUID.fromString(user.getId().getValue().toString()))
                .setEmail(user.getEmail())
                .setPhone(user.getPhone())
                .setAddress(user.getAddress())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setAvatarUrl(user.getAvatarUrl())
                .setDob(user.getDob().toInstant())
                .setUserRequestStatus(UserRequestStatus.UPDATING)
                .build();
    }

    public UserRequestAvroModel userDeletedToUserRequestAvroModel(UserDeletedEvent userDeletedEvent) {
        User user = userDeletedEvent.getUser();
        return UserRequestAvroModel.newBuilder()
                .setId(UUID.fromString(UUID.randomUUID().toString()))
                .setSagaId(UUID.fromString(""))
                .setUserId(UUID.fromString(user.getId().getValue().toString()))
                .setIsDeleted(user.getDeleted())
                .setUserRequestStatus(UserRequestStatus.DELETING)
                .build();
    }

    public UserResponse userResponseAvroModelToUserResponse(UserResponseAvroModel userResponseAvroModel) {
        return UserResponse.builder()
                .id(userResponseAvroModel.getUserId().toString())
                .sagaId(userResponseAvroModel.getSagaId().toString())
                .userId(userResponseAvroModel.getUserId().toString())
                .firstName(userResponseAvroModel.getFirstName())
                .lastName(userResponseAvroModel.getLastName())
                .email(userResponseAvroModel.getEmail())
                .phone(userResponseAvroModel.getPhone())
                .address(userResponseAvroModel.getAddress())
                .avatarUrl(userResponseAvroModel.getAvatarUrl())
                .dob(userResponseAvroModel.getDob())
                .createdAt(userResponseAvroModel.getCreatedAt())
                .updatedAt(userResponseAvroModel.getUpdatedAt())
                .isDeleted(userResponseAvroModel.getIsDeleted())
                .userResponseStatus(UserResponseStatus.valueOf(userResponseAvroModel.getUserResponseStatus().name()))
                .failureMessages(userResponseAvroModel.getFailureMessages())
                .build();

    }
}
