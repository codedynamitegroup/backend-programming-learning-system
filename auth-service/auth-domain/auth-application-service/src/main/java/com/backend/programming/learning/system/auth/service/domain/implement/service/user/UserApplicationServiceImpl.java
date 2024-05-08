package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryAllUsersCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryUserByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryAllUsersResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class UserApplicationServiceImpl implements UserApplicationService {
    private final UserCommandHandler userCommandHandler;

    UserApplicationServiceImpl(UserCommandHandler userCommandHandler) {
        this.userCommandHandler = userCommandHandler;
    }

    @Override
    public CreateUserResponse createUser(CreateUserCommand createUserCommand, String token) {
        return userCommandHandler.createUser(createUserCommand, token);
    }

    @Override
    public UserEntityResponse findUserById(QueryUserByIdCommand queryUserCommand) {
        return userCommandHandler.queryUser(queryUserCommand);
    }

    @Override
    public QueryAllUsersResponse findAllUsers(QueryAllUsersCommand queryAllUsersCommand) {
        return userCommandHandler.queryAllUsers(queryAllUsersCommand);
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserCommand updateUserCommand) {
        return userCommandHandler.updateUser(updateUserCommand);
    }

    @Override
    public DeleteUserResponse deleteUserById(DeleteUserCommand deleteUserCommand) {
        return userCommandHandler.deleteUser(deleteUserCommand);
    }

    @Override
    public LoginUserResponse loginUser(LoginUserCommand loginUserCommand) {
        return userCommandHandler.loginUser(loginUserCommand);
    }

    @Override
    public RefreshTokenUserResponse refreshTokenUser(RefreshTokenUserCommand refreshTokenUserCommand) {
        return userCommandHandler.refreshTokenUser(refreshTokenUserCommand);
    }
}
