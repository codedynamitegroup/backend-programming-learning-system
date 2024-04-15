package com.backend.programming.learning.system.auth.service.domain.implement.user;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserDeletedMessagePublisher;
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
    private final UserDeletedMessagePublisher userDeletedMessagePublisher;

    public UserDeleteHelper(AuthDomainService authDomainService, UserRepository userRepository, UserDeletedMessagePublisher userDeletedMessagePublisher) {
        this.authDomainService = authDomainService;
        this.userRepository = userRepository;
        this.userDeletedMessagePublisher = userDeletedMessagePublisher;
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
        if (Boolean.TRUE.equals(user.getDeleted())) {
            log.warn("User with id: {} is already deleted", deleteUserCommand.getUserId());
            throw new AuthNotFoundException("User with id: " + deleteUserCommand.getUserId() +
                    " is already deleted");
        }

        UserDeletedEvent userDeletedEvent = authDomainService.deleteUser(user, userDeletedMessagePublisher);
        userRepository.save(user);
        return userDeletedEvent;
    }
}
