package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.mapper.AuthDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.UserCreatedRequestMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserCreateCommandHandler {

    private final UserCreateHelper authCreateHelper;

    private final AuthDataMapper authDataMapper;

    private final UserCreatedRequestMessagePublisher userCreatedRequestMessagePublisher;

    public UserCreateCommandHandler(UserCreateHelper authCreateHelper, AuthDataMapper authDataMapper, UserCreatedRequestMessagePublisher userCreatedRequestMessagePublisher) {
        this.authCreateHelper = authCreateHelper;
        this.authDataMapper = authDataMapper;
        this.userCreatedRequestMessagePublisher = userCreatedRequestMessagePublisher;
    }

    public CreateUserResponse createUser(CreateUserCommand createOrderCommand) {
        UserCreatedEvent userCreatedEvent = authCreateHelper.persisUser(createOrderCommand);
        log.info("Order is created with id: {}", userCreatedEvent.getUser().getId().getValue());
        userCreatedRequestMessagePublisher.publish(userCreatedEvent);
        return authDataMapper.userToCreateUserResponse(userCreatedEvent.getUser(),
                "User created successfully");
    }

}
