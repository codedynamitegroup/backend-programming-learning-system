package com.backend.programming.learning.system.core.service.domain.mapper.user;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.user.QueryUserResponse;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper {

    public QueryUserResponse userToQueryUserResponse(User user) {
        return QueryUserResponse.builder()
                .userId(user.getId().getValue())
                .email(user.getEmail())
                .build();
    }
}
