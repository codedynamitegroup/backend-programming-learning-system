package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.dto.method.change_password.ChangedPasswordUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.change_password.ChangedPasswordUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.SocialLoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.logout.LogoutUserEmailCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.logout.LogoutUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.*;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserEmailCommand;
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
    public CreateUserResponse createUser(CreateUserCommand createUserCommand) {
        return userCommandHandler.createUser(createUserCommand);
    }

    @Override
    public UserEntityResponse findUserById(QueryUserByIdCommand queryUserCommand) {
        return userCommandHandler.queryUser(queryUserCommand);
    }

    @Override
    public UserEntityResponse findUserByEmail(QueryUserByEmailCommand queryUserByEmailCommand) {
        return userCommandHandler.queryUserByEmail(queryUserByEmailCommand);
    }

    @Override
    public QueryAllUsersResponse findAllUsers(QueryAllUsersCommand queryAllUsersCommand) {
        return userCommandHandler.queryAllUsers(queryAllUsersCommand);
    }

    @Override
    public QueryAllUsersResponse findAllUsersByOrganization(QueryAllUsersByOrganizationCommand queryAllUsersByOrganizationCommand) {
        return userCommandHandler.queryAllUsersByOrganization(queryAllUsersByOrganizationCommand);
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
    public LoginUserResponse socialLoginUser(SocialLoginUserCommand socialLoginUserCommand) {
        return userCommandHandler.socialLoginUser(socialLoginUserCommand);
    }

    @Override
    public RefreshTokenUserResponse refreshTokenUser(RefreshTokenUserEmailCommand refreshTokenUserCommand) {
        return userCommandHandler.refreshTokenUser(refreshTokenUserCommand);
    }

    @Override
    public LogoutUserResponse logoutUser(LogoutUserEmailCommand logoutUserEmailCommand) {
        return userCommandHandler.logoutUser(logoutUserEmailCommand);
    }

    @Override
    public ChangedPasswordUserResponse changePasswordUser(ChangedPasswordUserCommand changedPasswordUserCommand) {
        return userCommandHandler.changePasswordUser(changedPasswordUserCommand);
    }
}
