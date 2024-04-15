package com.backend.programming.learning.system.auth.service.domain.implement.user;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserCreatedMessagePublisher;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class UserCreateHelper {
    private final AuthDomainService authDomainService;
    private final UserRepository userRepository;
    private final UserDataMapper authDataMapper;
    private final UserCreatedMessagePublisher userCreatedMessagePublisher;

    public UserCreateHelper(AuthDomainService authDomainService, UserRepository userRepository, UserDataMapper authDataMapper, UserCreatedMessagePublisher userCreatedMessagePublisher) {
        this.authDomainService = authDomainService;
        this.userRepository = userRepository;
        this.authDataMapper = authDataMapper;
        this.userCreatedMessagePublisher = userCreatedMessagePublisher;
    }

    @Transactional
    public UserCreatedEvent persistUser(CreateUserCommand createUserCommand) {
        User user = authDataMapper.createUserCommandToUser(createUserCommand);
        findUserWithEmail(user.getEmail());
        UserCreatedEvent userCreatedEvent = authDomainService.createUser(user, userCreatedMessagePublisher);
        saveUser(user);
        log.info("User is created with id: {}", user.getId().getValue());
        return userCreatedEvent;
    }

    private void findUserWithEmail(String email) {
        Optional<User> userResult = userRepository.findByEmail(email);
        if (userResult.isPresent()) {
            log.warn("Found user with email: {}", email);
            throw new AuthDomainException("Found user with email: " + email);
        }
    }

    private User saveUser(User user) {
        User userResult = userRepository.save(user);
        if (userResult == null) {
            log.error("Could not save user!");
            throw new AuthDomainException("Could not save user!");
        }
        log.info("User is saved with id: {}", userResult.getId().getValue());
        return userResult;
    }
}
