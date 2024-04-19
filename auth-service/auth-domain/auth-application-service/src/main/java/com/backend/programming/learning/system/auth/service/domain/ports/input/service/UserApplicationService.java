package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryAllUsersCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryUserByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryAllUsersResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;

import javax.validation.Valid;
import java.util.List;

public interface UserApplicationService {
    CreateUserResponse createUser(@Valid CreateUserCommand createUserCommand);
    UserEntityResponse findUserById(@Valid QueryUserByIdCommand queryUserCommand);
    QueryAllUsersResponse findAllUsers(QueryAllUsersCommand queryAllUsersCommand);
    DeleteUserResponse deleteUserById(@Valid DeleteUserCommand deleteUserCommand);
}
