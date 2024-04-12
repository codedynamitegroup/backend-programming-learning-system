package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserCreateCommandHandler {

    private final UserCreateHelper authCreateHelper;

    private final UserDataMapper userDataMapper;

    public UserCreateCommandHandler(UserCreateHelper authCreateHelper, UserDataMapper userDataMapper) {
        this.authCreateHelper = authCreateHelper;
        this.userDataMapper = userDataMapper;
    }

    public CreateUserResponse createUser(CreateUserCommand createOrderCommand) {
        User userCreated = authCreateHelper.persistUser(createOrderCommand);
        log.info("Order is created with id: {}", userCreated.getId().getValue());
        return userDataMapper.userToCreateUserResponse(userCreated,
                "User created successfully");
    }

}
