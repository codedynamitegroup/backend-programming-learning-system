package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class UserApplicationServiceImpl implements UserApplicationService {
    private final UserCreateCommandHandler userCreateCommandHandler;

    private final UserQueryCommandHandler userQueryCommandHandler;

    UserApplicationServiceImpl(UserCreateCommandHandler userCreateCommandHandler, UserQueryCommandHandler userQueryCommandHandler) {
        this.userCreateCommandHandler = userCreateCommandHandler;
        this.userQueryCommandHandler = userQueryCommandHandler;
    }

    @Override
    public CreateUserResponse createUser(CreateUserCommand createUserCommand) {
        return userCreateCommandHandler.createUser(createUserCommand);
    }

    @Override
    public QueryUserResponse findUserById(QueryUserCommand queryUserCommand) {
        return userQueryCommandHandler.queryUser(queryUserCommand);
    }
}
