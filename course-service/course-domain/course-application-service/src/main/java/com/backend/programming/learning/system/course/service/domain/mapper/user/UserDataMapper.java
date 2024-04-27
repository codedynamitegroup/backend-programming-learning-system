package com.backend.programming.learning.system.course.service.domain.mapper.user;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserCreateRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserDeleteRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.UUID;

@Component
public class UserDataMapper {
    public UserResponseEntity userToUserResponseEntity(User user) {
        return UserResponseEntity.builder()
                .userId(user.getId().getValue())
                .email(user.getEmail())
                .build();
    }


    public User userCreateRequestToUser(UserCreateRequest userRequest) {
        return User.builder()
                .id(new UserId(UUID.fromString(userRequest.getUserId())))
                .email(userRequest.getEmail())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .phone(userRequest.getPhone())
                .createdAt(userRequest.getCreatedAt().atZone(ZoneId.of("UTC")))
                .updatedAt(userRequest.getUpdatedAt().atZone(ZoneId.of("UTC")))
                .isDeleted(userRequest.getIsDeleted())
                .build();
    }

    public User userDeleteRequestToUser(UserDeleteRequest userRequest) {
        return User.builder()
                .id(new UserId(UUID.fromString(userRequest.getUserId())))
                .build();
    }

    public User userUpdateRequestToUser(UserUpdateRequest userUpdateRequest) {
        return User.builder()
                .id(new UserId(UUID.fromString(userUpdateRequest.getUserId())))
                .firstName(userUpdateRequest.getFirstName())
                .lastName(userUpdateRequest.getLastName())
                .address(userUpdateRequest.getAddress())
                .avatarUrl(userUpdateRequest.getAvatarUrl())
                .dob(userUpdateRequest.getDob().atZone(ZoneId.of("UTC")))
                .phone(userUpdateRequest.getPhone())
                .updatedAt(userUpdateRequest.getUpdatedAt().atZone(ZoneId.of("UTC")))
                .build();
    }


}
