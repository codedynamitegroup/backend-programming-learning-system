package com.backend.programming.learning.system.mapper.user;

import com.backend.programming.learning.system.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper {
    public UserResponseEntity userToUserResponseEntity(User user) {
        return UserResponseEntity.builder()
                .userId(user.getId().getValue())
                .email(user.getEmail())
                .build();
    }
}
