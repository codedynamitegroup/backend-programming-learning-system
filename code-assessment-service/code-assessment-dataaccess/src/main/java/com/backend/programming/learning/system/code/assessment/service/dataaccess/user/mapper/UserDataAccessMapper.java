package com.backend.programming.learning.system.code.assessment.service.dataaccess.user.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class UserDataAccessMapper {

    public User userEntityToUser(UserEntity entity) {
        return User.builder()
                .id(new UserId(entity.getId()))
                .email(entity.getEmail())
                .dob(entity.getDob())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .avatarUrl(entity.getAvatarUrl())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .isDeleted(entity.getIsDeleted())
                .build();
    }

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
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .isDeleted(user.getDeleted())
                .build();
    }
}
