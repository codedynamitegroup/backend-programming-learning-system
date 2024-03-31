package com.backend.programming.learning.system;

import com.backend.programming.learning.system.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.event.UserCreatedEvent;
import com.backend.programming.learning.system.mapper.AuthDataMapper;
import com.backend.programming.learning.system.ports.output.message.publisher.UserCreatedRequestMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthCreateCommandHandler {

    private final AuthCreateHelper authCreateHelper;

    private final AuthDataMapper authDataMapper;

    private final UserCreatedRequestMessagePublisher userCreatedRequestMessagePublisher;

    public AuthCreateCommandHandler(AuthCreateHelper authCreateHelper, AuthDataMapper authDataMapper, UserCreatedRequestMessagePublisher userCreatedRequestMessagePublisher) {
        this.authCreateHelper = authCreateHelper;
        this.authDataMapper = authDataMapper;
        this.userCreatedRequestMessagePublisher = userCreatedRequestMessagePublisher;
    }

    public CreateUserResponse createOrder(CreateUserCommand createOrderCommand) {
        UserCreatedEvent userCreatedEvent = authCreateHelper.persisUser(createOrderCommand);
        log.info("Order is created with id: {}", userCreatedEvent.getUser().getId().getValue());
        userCreatedRequestMessagePublisher.publish(userCreatedEvent);
        return authDataMapper.userToCreateUserResponse(userCreatedEvent.getUser(),
                "User created successfully");
    }

}
