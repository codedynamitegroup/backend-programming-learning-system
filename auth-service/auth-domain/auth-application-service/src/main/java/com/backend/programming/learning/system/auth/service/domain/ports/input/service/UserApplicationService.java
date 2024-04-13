package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.create.*;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;
import javax.validation.Valid;

public interface UserApplicationService {
    CreateUserResponse createUser(@Valid CreateUserCommand createUserCommand);
    QueryUserResponse findUserById(@Valid QueryUserCommand queryUserCommand);
    DeleteUserResponse deleteUserById(@Valid DeleteUserCommand deleteUserCommand);
}
