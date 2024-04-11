package com.backend.programming.learning.system;

import com.backend.programming.learning.system.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.event.UserCreatedEvent;
import com.backend.programming.learning.system.exception.AuthDomainException;
import com.backend.programming.learning.system.mapper.AuthDataMapper;
import com.backend.programming.learning.system.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class AuthCreateHelper {

    private final AuthDomainService authDomainService;

    private final UserRepository userRepository;

    private final AuthDataMapper authDataMapper;

    public AuthCreateHelper(AuthDomainService authDomainService, UserRepository userRepository, AuthDataMapper authDataMapper) {
        this.authDomainService = authDomainService;
        this.userRepository = userRepository;
        this.authDataMapper = authDataMapper;
    }

    @Transactional
    public UserCreatedEvent persisUser(CreateUserCommand createUserCommand) {
        User user = authDataMapper.createUserCommandToUser(createUserCommand);
        UserCreatedEvent userCreatedEvent = authDomainService.createUser(user);
        saveUser(user);
        log.info("Order is created with id: {}", userCreatedEvent.getUser().getId().getValue());
        return userCreatedEvent;
    }

    private User saveUser(User user) {
        User userResult = userRepository.save(user);
        if (userResult == null) {
            log.error("Could not save auth!");
            throw new AuthDomainException("Could not save auth!");
        }
        log.info("User is saved with id: {}", userResult.getId().getValue());
        return userResult;
    }
}
