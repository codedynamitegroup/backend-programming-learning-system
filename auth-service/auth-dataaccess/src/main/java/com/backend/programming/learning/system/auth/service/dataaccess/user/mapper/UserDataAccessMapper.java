package com.backend.programming.learning.system.auth.service.dataaccess.user.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class UserDataAccessMapper {
    public User userEntityToUser(UserEntity userEntity) {
        return User.builder()
                .id(new UserId(userEntity.getId()))
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .address(userEntity.getAddress())
                .dob(userEntity.getDob())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .phone(userEntity.getPhone())
                .avatarUrl(userEntity.getAvatarUrl())
                .lastLogin(userEntity.getLastLogin())
                .refreshToken(userEntity.getRefreshToken())
                .isLinkedWithGoogle(userEntity.getIsLinkedWithGoogle())
                .isLinkedWithMicrosoft(userEntity.getIsLinkedWithMicrosoft())
                .isDeleted(userEntity.getIsDeleted())
                .build();
    }

    public UserEntity userToUserEntity(User user) {
        return UserEntity.builder()
                .id(user.getId().getValue())
                .email(user.getEmail())
                .username(user.getUsername())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .address(user.getAddress())
                .dob(user.getDob())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .avatarUrl(user.getAvatarUrl())
                .lastLogin(user.getLastLogin())
                .refreshToken(user.getRefreshToken())
                .isLinkedWithGoogle(user.getLinkedWithGoogle())
                .isLinkedWithMicrosoft(user.getLinkedWithMicrosoft())
                .isDeleted(user.getDeleted())
                .build();
    }
}
