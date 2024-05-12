package com.backend.programming.learning.system.course.service.domain.implement.service.user;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.course.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.course.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserCreateHelper {
    private final CourseDomainService courseDomainService;
    private final UserRepository userRepository;
    private final UserDataMapper authDataMapper;

    @Transactional
    public UserCreatedEvent persistUser(CreateUserCommand createUserCommand) {
        User user = authDataMapper.createUserCommandToUser(createUserCommand);
        findUserWithEmail(user.getEmail());
        UserCreatedEvent userCreatedEvent = courseDomainService.createUser(user);
        saveUser(user);
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
            log.error("Could not create user!");
            throw new AuthDomainException("Could not create user!");
        }
        log.info("User is created with id: {}", userResult.getId().getValue());
        return userResult;
    }
}
