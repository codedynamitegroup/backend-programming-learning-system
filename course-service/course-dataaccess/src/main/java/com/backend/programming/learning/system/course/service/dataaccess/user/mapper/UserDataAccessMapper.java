package com.backend.programming.learning.system.course.service.dataaccess.user.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDataAccessMapper {
    public UserEntity userToUserEntity(User user) {
        return UserEntity.builder()
                .id(user.getId().getValue())
                .email(user.getEmail())
                .dob(user.getDob())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .avatarUrl(user.getAvatarUrl())
                .lastLogin(user.getLastLogin())
                .is_deleted(user.getDeleted())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public User userEntityToUser(UserEntity userEntity) {
        return User.builder()
                .id(new UserId(userEntity.getId()))
                .email(userEntity.getEmail())
                .dob(userEntity.getDob())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .phone(userEntity.getPhone())
                .address(userEntity.getAddress())
                .avatarUrl(userEntity.getAvatarUrl())
                .lastLogin(userEntity.getLastLogin())
                .isDeleted(userEntity.getIs_deleted())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .build();

    }
}
