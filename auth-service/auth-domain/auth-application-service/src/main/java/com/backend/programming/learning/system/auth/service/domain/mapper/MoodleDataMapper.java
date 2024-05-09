package com.backend.programming.learning.system.auth.service.domain.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_moodle.UserModel;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.auth.service.domain.mapper
 * Create by Dang Ngoc Tien
 * Date 5/2/2024 - 11:59 PM
 * Description: ...
 */
@Component
public class MoodleDataMapper {
    public UpdateUserCommand updateUser(UserModel userModel, User user) {
        return UpdateUserCommand.builder()
                .userId(user.getId().getValue())
                .dob(user.getDob())
                .firstName(userModel.getFirstname())
                .lastName(userModel.getLastname())
                .phone(userModel.getPhone1())
                .address(userModel.getAddress())
                .avatarUrl(userModel.getProfileimageurl())
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

    public CreateUserCommand createUser(UserModel userModel) {
        return CreateUserCommand.builder()
                .email(userModel.getEmail())
                .password("")
                .firstName(userModel.getFirstname())
                .lastName(userModel.getLastname())
                .phone(userModel.getPhone1())
                .build();
    }


    public CreateUserRoleCommand createRole(com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_moodle.Role role,
                                            Map<String, Role> roleMap, UUID userId) {
        return CreateUserRoleCommand.builder()
                .roleId(roleMap.get(role.getShortname().toLowerCase()).getId().getValue())
                .userId(userId)
                .name(role.getShortname())
                .createdBy(userId)
                .build();
    }
}
