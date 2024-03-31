package com.backend.programming.learning.system.ports.input.service;

import com.backend.programming.learning.system.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.dto.create.CreateUserResponse;
import jakarta.validation.Valid;

public interface AuthApplicationService {
    CreateUserResponse createOrder(@Valid CreateUserCommand createUserCommand);
}
