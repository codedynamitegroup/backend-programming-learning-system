package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
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

    public UserDeleteHelper(AuthDomainService authDomainService, UserRepository userRepository) {
        this.authDomainService = authDomainService;
        this.userRepository = userRepository;
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
        userRepository.save(user);
        return userDeletedEvent;
    }
}