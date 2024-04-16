package com.backend.programming.learning.system.auth.service.messaging.mapper;

import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.UserDeletedEvent;
import com.backend.programming.learning.system.kafka.auth.avro.model.UserRequestAvroModel;
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
                .setDisplayName(user.getFirstName())
                .setAvatarUrl(user.getAvatarUrl())
                .setDob(user.getDob().toInstant())
                .setCreatedAt(user.getCreatedAt().toInstant())
                .setIsActive(user.getDeleted())
                .build();
    }

    public UserRequestAvroModel userDeletedToUserRequestAvroModel(UserDeletedEvent userDeletedEvent) {
        User user = userDeletedEvent.getUser();
        return UserRequestAvroModel.newBuilder()
                .setId(UUID.fromString(UUID.randomUUID().toString()))
                .setSagaId(UUID.fromString(""))
                .setUserId(UUID.fromString(user.getId().getValue().toString()))
                .setEmail(user.getEmail())
                .setDisplayName(user.getFirstName())
                .setAvatarUrl(user.getAvatarUrl())
                .setDob(user.getDob().toInstant())
                .setCreatedAt(user.getCreatedAt().toInstant())
                .setIsActive(user.getDeleted())
                .build();
    }
}
