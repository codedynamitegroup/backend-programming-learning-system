package com.backend.programming.learning.system.core.service.dataaccess.user.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class UserDataAccessMapper {
    public User userEntityToUser(UserEntity userEntity) {
        return User.builder()
                .id(new UserId(userEntity.getId()))
                .email(userEntity.getEmail())
                .dob(userEntity.getDob())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .avatarUrl(userEntity.getAvatarUrl())
                .phone(userEntity.getPhone())
                .address(userEntity.getAddress())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .isDeleted(userEntity.getIsDeleted())
                .build();
    }

    public User userEntityToUserHideSensitiveData(UserEntity userEntity) {
        return User.builder()
                .id(new UserId(userEntity.getId()))
                .email(null)
                .dob(null)
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .avatarUrl(null)
                .phone(null)
                .address(null)
                .createdAt(null)
                .updatedAt(null)
                .isDeleted(null)
                .build();
    }

    public UserEntity userToUserEntity(User user) {
        return UserEntity.builder()
                .id(user.getId().getValue())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dob(user.getDob())
                .avatarUrl(user.getAvatarUrl())
                .phone(user.getPhone())
                .address(user.getAddress())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .isDeleted(user.getDeleted())
                .build();
    }

    public UserEntity userToUserEntityHideSensitiveData(User user) {
        return UserEntity.builder()
                .id(user.getId().getValue())
                .email(null)
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dob(null)
                .avatarUrl(null)
                .phone(null)
                .address(null)
                .createdAt(null)
                .updatedAt(null)
                .isDeleted(null)
                .build();
    }
}
