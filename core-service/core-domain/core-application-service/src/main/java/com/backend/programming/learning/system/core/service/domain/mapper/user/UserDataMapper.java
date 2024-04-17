package com.backend.programming.learning.system.core.service.domain.mapper.user;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper {

    public UserResponseEntity userToQueryUserResponse(User user) {
        return UserResponseEntity.builder()
                .userId(user.getId().getValue())
                .email(user.getEmail())
                .build();
    }
}
