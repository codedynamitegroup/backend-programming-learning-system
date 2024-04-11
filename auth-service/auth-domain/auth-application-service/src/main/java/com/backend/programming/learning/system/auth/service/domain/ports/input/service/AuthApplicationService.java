package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface AuthApplicationService {
    CreateUserResponse createUser(@Valid CreateUserCommand createUserCommand);
    QueryUserResponse findUserById(QueryUserCommand queryUserCommand);
}
