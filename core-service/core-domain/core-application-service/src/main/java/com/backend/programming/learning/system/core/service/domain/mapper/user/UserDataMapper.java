package com.backend.programming.learning.system.core.service.domain.mapper.user;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserCreateRequest;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserDeleteRequest;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserUpdateRequest;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.util.UUID;

@Component
public class UserDataMapper {

    public UserResponseEntity userToUserResponseEntity(User user) {
        return UserResponseEntity.builder()
                .userId(user.getId().getValue())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dob(user.getDob())
                .avatarUrl(user.getAvatarUrl())
                .phone(user.getPhone())
                .address(user.getAddress())
                .build();
    }

    public User userCreateRequestToUser(UserCreateRequest userRequest) {
        return User.builder()
                .id(new UserId(UUID.fromString(userRequest.getUserId())))
                .email(userRequest.getEmail())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .phone(userRequest.getPhone())
                .createdAt(userRequest.getCreatedAt().atZone(ZoneId.of(DomainConstants.ASIA_HCM)))
                .updatedAt(userRequest.getUpdatedAt().atZone(ZoneId.of(DomainConstants.ASIA_HCM)))
                .isDeleted(userRequest.getIsDeleted())
                .build();
    }

    public User userUpdateRequestToUser(UserUpdateRequest userUpdateRequest) {
        return User.builder()
                .id(new UserId(UUID.fromString(userUpdateRequest.getUserId())))
                .firstName(userUpdateRequest.getFirstName())
                .lastName(userUpdateRequest.getLastName())
                .address(userUpdateRequest.getAddress())
                .avatarUrl(userUpdateRequest.getAvatarUrl())
                .dob(userUpdateRequest.getDob().atZone(ZoneId.of(DomainConstants.ASIA_HCM)))
                .phone(userUpdateRequest.getPhone())
                .updatedAt(userUpdateRequest.getUpdatedAt().atZone(ZoneId.of(DomainConstants.ASIA_HCM)))
                .build();
    }

    public User userDeleteRequestToUser(UserDeleteRequest userDeleteRequest) {
        return User.builder()
                .id(new UserId(UUID.fromString(userDeleteRequest.getUserId())))
                .isDeleted(userDeleteRequest.getIsDeleted())
                .build();
    }
}
