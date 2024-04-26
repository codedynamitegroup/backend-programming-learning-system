package com.backend.programming.learning.system.course.service.domain.mapper.user;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.User;
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
