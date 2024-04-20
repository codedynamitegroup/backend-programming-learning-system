package com.backend.programming.learning.system.auth.service.domain.implement.user;

import com.backend.programming.learning.system.auth.service.domain.dto.method.update.role.UpdateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class UserUpdateHelper {
    private final UserRepository userRepository;

    public UserUpdateHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User persistUser(UpdateUserCommand updateUserCommand) {
        User user = getUser(updateUserCommand.getUserId());

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

        return saveUser(user);
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findById(new UserId(userId));
        if (user.isEmpty()) {
            log.error("User with id: {} could not be found!", userId);
            throw new AuthDomainException("User with id: " + userId + " could not be found!");
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
