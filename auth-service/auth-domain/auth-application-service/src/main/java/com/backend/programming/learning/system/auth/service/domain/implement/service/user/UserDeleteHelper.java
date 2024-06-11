package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.auth_to_any_services.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class UserDeleteHelper {
    private final AuthDomainService authDomainService;
    private final UserRepository userRepository;
    private final UserKeycloakApplicationService keycloakApplicationService;

    public UserDeleteHelper(AuthDomainService authDomainService, UserRepository userRepository, UserKeycloakApplicationService keycloakApplicationService) {
        this.authDomainService = authDomainService;
        this.userRepository = userRepository;
        this.keycloakApplicationService = keycloakApplicationService;
    }

    @Transactional
    public UserDeletedEvent deleteUser(DeleteUserCommand deleteUserCommand) {
        Optional<User> userResult =
                userRepository.findById(new UserId(deleteUserCommand.getUserId()));
        if (userResult.isEmpty()) {
            log.warn("Could not find user with id: {}", deleteUserCommand.getUserId());
            throw new AuthNotFoundException("Could not find user with id: " +
                    deleteUserCommand.getUserId());
        }

        User user = userResult.get();

        UserDeletedEvent userDeletedEvent = authDomainService.deleteUser(user);
        User userSaved = saveUser(user);
        keycloakApplicationService.deleteUser(userSaved);
        return userDeletedEvent;
    }

    private User saveUser(User user) {
        User userResult = userRepository.save(user);
        if (userResult == null) {
            log.error("Could not delete user!");
            throw new AuthDomainException("Could not delete user!");
        }
        log.info("User is deleted with id: {}", userResult.getId().getValue());
        return userResult;
    }
}
