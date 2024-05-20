package com.backend.programming.learning.system.auth.service.domain.implement.service.user_role;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserRoleDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.RoleKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.RoleRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRoleRepository;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserRoleCreateHelper {
    private final AuthDomainService authDomainService;
    private final UserRoleRepository userRoleRepository;
    private final UserRoleDataMapper userRoleDataMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RoleKeycloakApplicationService roleKeycloakApplicationService;

    @Transactional
    public UserRole persistUserRole(CreateUserRoleCommand createUserRoleCommand) {
        User createdBy = getUser(createUserRoleCommand.getCreatedBy());
        User user = getUser(createUserRoleCommand.getUserId());
        Role role = getRole(createUserRoleCommand.getRoleId());

        UserRole userRole = userRoleDataMapper.createUserRoleCommandToUserRole(createUserRoleCommand);
        userRole.setRole(role);
        userRole.setUser(user);
        userRole.setCreatedBy(createdBy);
        userRole.setUpdatedBy(createdBy);

        authDomainService.createUserRole(userRole);
        roleKeycloakApplicationService.assignRole(user.getEmail(), role.getName());
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

    private Role getRole(UUID roleId) {
        Optional<Role> role = roleRepository.findById(new RoleId(roleId));
        if (role.isEmpty()) {
            log.error("Role with id: {} could not be found!", roleId);
            throw new AuthDomainException("Role with id: " + roleId + " could not be found!");
        }
        return role.get();
    }


    private UserRole saveUserRole(UserRole userRole) {
        UserRole userRoleResult = userRoleRepository.save(userRole);
        if (userRoleResult == null) {
            log.error("Could not save user role!");
            throw new AuthDomainException("Could not save user role!");
        }
        log.info("User role is saved with id: {}", userRoleResult.getId().getValue());
        return userRoleResult;
    }
}
