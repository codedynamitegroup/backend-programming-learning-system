package com.backend.programming.learning.system.auth.service.domain.implement.user_role;

import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user_role.UpdateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRoleRepository;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.auth.service.domain.valueobject.UserRoleId;
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
public class UserRoleUpdateHelper {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    public UserRoleUpdateHelper(UserRoleRepository userRoleRepository, UserRepository userRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public UserRole persistUserRole(UpdateUserRoleCommand updateUserRoleCommand) {
        UserRole userRole = getUserRole(updateUserRoleCommand.getUserRoleId());
        User updateBy = getUser(updateUserRoleCommand.getUpdatedBy());

        userRole.setUpdatedBy(updateBy);
        userRole.setUpdatedAt(ZonedDateTime.now(ZoneId.of("UTC")));

        if (updateUserRoleCommand.getName() != null) {
            userRole.setName(updateUserRoleCommand.getName());
        }

        if (updateUserRoleCommand.getIsActive() != null) {
            userRole.setActive(updateUserRoleCommand.getIsActive());
        }

        return saveUserRole(userRole);
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findById(new UserId(userId));
        if (user.isEmpty()) {
            log.error("User with id: {} could not be found!", userId);
            throw new AuthDomainException("User with id: " + userId + " could not be found!");
        }
        return user.get();
    }

    private UserRole getUserRole(UUID userRoleId) {
        Optional<UserRole> userRole = userRoleRepository.findById(new UserRoleId(userRoleId));
        if (userRole.isEmpty()) {
            log.warn("User role with id: {} not found", userRoleId);
            throw new AuthNotFoundException("Could not find user role with id: " + userRoleId);
        }
        return userRole.get();
    }

    private UserRole saveUserRole(UserRole userRole) {
        UserRole userRoleResult = userRoleRepository.save(userRole);
        if (userRoleResult == null) {
            log.error("Could not update user role!");
            throw new AuthDomainException("Could not update user role!");
        }
        log.info("User role is updated with id: {}", userRoleResult.getId().getValue());
        return userRoleResult;
    }
}
