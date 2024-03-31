package com.backend.programming.learning.system;

import com.backend.programming.learning.system.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.ports.input.service.AuthApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class AuthApplicationServiceImpl implements AuthApplicationService {

    @Override
    public CreateUserResponse createOrder(CreateUserCommand createUserCommand) {
        return null;
    }
}
