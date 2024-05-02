package com.backend.programming.learning.system.auth.service.domain.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_moodle.UserModel;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.auth.service.domain.mapper
 * Create by Dang Ngoc Tien
 * Date 5/2/2024 - 11:59 PM
 * Description: ...
 */
@Component
public class MoodleDataMapper {
    public User updateUser(UserModel userModel, User user) {
        return User.builder()
                .id(user.getId())
                .email(userModel.getEmail())
                .password(user.getPassword())
                .dob(user.getDob())
                .firstName(userModel.getFirstname())
                .lastName(userModel.getLastname())
                .phone(user.getPhone())
                .address(user.getAddress())
                .avatarUrl(userModel.getProfileimageurl())
                .refreshToken(user.getRefreshToken())
                .copyState(CopyState.UPDATED)
                .lastLogin(user.getLastLogin())
                .createdAt(user.getCreatedAt())
                .updatedAt(ZonedDateTime.now())
                .isDeleted(user.getDeleted())
                .build();
    }

    public List<UserEntityResponse> userEntityResponseList(List<User> result) {
        return result.stream()
                .map(this::userEntityResponse)
                .toList();
    }
    public UserEntityResponse userEntityResponse(User user) {
        return UserEntityResponse.builder()
                .userId(user.getId().getValue())
                .email(user.getEmail())
                .dob(user.getDob())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .avatarUrl(user.getAvatarUrl())
                .lastIp(user.getLastIp())
                .lastLogin(user.getLastLogin())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .isDeleted(user.getDeleted())
                .build();
    }

    public User createUser(UserModel userModel) {
        return User.builder()
                .id(new UserId(UUID.randomUUID()))
                .email(userModel.getEmail())
                .password("123456")
                .dob(ZonedDateTime.now())
                .firstName(userModel.getFirstname())
                .lastName(userModel.getLastname())
                .phone("")
                .address(userModel.getCountry())
                .avatarUrl(userModel.getProfileimageurl())
                .refreshToken("")
                .lastIp("")
                .copyState(CopyState.CREATED)
                .lastLogin(ZonedDateTime.now())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .isDeleted(false)
                .build();
    }
}
