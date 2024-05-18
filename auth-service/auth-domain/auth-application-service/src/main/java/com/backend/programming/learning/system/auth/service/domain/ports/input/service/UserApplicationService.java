package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.SocialLoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.SocialLoginUserProfileCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryAllUsersByOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryAllUsersCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryUserByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryAllUsersResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;

import jakarta.validation.Valid;

public interface UserApplicationService {
    CreateUserResponse createUser(@Valid CreateUserCommand createUserCommand);
    UserEntityResponse findUserById(@Valid QueryUserByIdCommand queryUserCommand);
    QueryAllUsersResponse findAllUsers(QueryAllUsersCommand queryAllUsersCommand);
    QueryAllUsersResponse findAllUsersByOrganization(QueryAllUsersByOrganizationCommand queryAllUsersByOrganizationCommand);
    UpdateUserResponse updateUser(@Valid UpdateUserCommand updateUserCommand);
    DeleteUserResponse deleteUserById(@Valid DeleteUserCommand deleteUserCommand);
    LoginUserResponse loginUser(@Valid LoginUserCommand loginUserCommand);
    LoginUserResponse socialLoginUser(@Valid SocialLoginUserProfileCommand socialLoginUserProfileCommand);
    RefreshTokenUserResponse refreshTokenUser(@Valid RefreshTokenUserCommand refreshTokenUserCommand);
}
