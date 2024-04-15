package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.*;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Slf4j
@Validated
@Service
class UserApplicationServiceImpl implements UserApplicationService {
    private final UserCommandHandler userCommandHandler;

    UserApplicationServiceImpl(UserCommandHandler userCommandHandler) {
        this.userCommandHandler = userCommandHandler;
    }

    @Override
    public CreateUserResponse createUser(CreateUserCommand createUserCommand) {
        return userCommandHandler.createUser(createUserCommand);
    }

    @Override
    public QueryUserResponse findUserById(QueryUserCommand queryUserCommand) {
        return userCommandHandler.queryUser(queryUserCommand);
    }

    @Override
    public List<QueryUserResponse> findAllUsers() {
        return userCommandHandler.queryAllUsers();
    }

    @Override
    public DeleteUserResponse deleteUserById(DeleteUserCommand deleteUserCommand) {
        return userCommandHandler.deleteUser(deleteUserCommand);
    }
}
