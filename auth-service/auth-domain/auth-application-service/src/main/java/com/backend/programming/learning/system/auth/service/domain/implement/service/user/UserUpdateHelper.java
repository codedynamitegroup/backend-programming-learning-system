package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.auth_to_any_services.UserUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

@Slf4j
@Component
public class UserUpdateHelper {
    private final UserRepository userRepository;
    private final AuthDomainService authDomainService;
    private final UserKeycloakApplicationService keycloakApplicationService;

    public UserUpdateHelper(UserRepository userRepository, AuthDomainService authDomainService, UserKeycloakApplicationService keycloakApplicationService) {
        this.userRepository = userRepository;
        this.authDomainService = authDomainService;
        this.keycloakApplicationService = keycloakApplicationService;
    }

    @Transactional
    public UserUpdatedEvent persistUser(UpdateUserCommand updateUserCommand) {
        User user = getUser(updateUserCommand.getEmail());
        user.setUpdatedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));

        if (updateUserCommand.getDob() != null) {
            user.setDob(updateUserCommand.getDob());
        }
        if (updateUserCommand.getFirstName() != null) {
            user.setFirstName(updateUserCommand.getFirstName());
        }
        if (updateUserCommand.getLastName() != null) {
            user.setLastName(updateUserCommand.getLastName());
        }
        if (updateUserCommand.getPhone() != null) {
            user.setPhone(updateUserCommand.getPhone());
        }
        if (updateUserCommand.getAddress() != null) {
            user.setAddress(updateUserCommand.getAddress());
        }
        if (updateUserCommand.getAvatarUrl() != null) {
            user.setAvatarUrl(updateUserCommand.getAvatarUrl());
        }

        UserUpdatedEvent userUpdatedEvent = authDomainService.updateUser(user);

        User userSaved = saveUser(user);
        keycloakApplicationService.updateUser(userSaved);
        return userUpdatedEvent;
    }

    private User getUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            log.error("User with email: {} could not be found!", email);
            throw new AuthDomainException("User with email: " + email + " could not be found!");
        }
        return user.get();
    }

    private User saveUser(User user) {
        User userResult = userRepository.save(user);
        if (userResult == null) {
            log.error("Could not update user!");
            throw new AuthDomainException("Could not update user!");
        }
        log.info("User is updated with id: {}", userResult.getId().getValue());
        return userResult;
    }
}
