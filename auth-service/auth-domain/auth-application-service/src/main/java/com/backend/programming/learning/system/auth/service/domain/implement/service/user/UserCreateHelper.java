package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateSocialLoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.RegisterUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.auth_to_any_services.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.implement.service.role.RoleQueryHelper;
import com.backend.programming.learning.system.auth.service.domain.implement.service.user_role.UserRoleCreateHelper;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserCreateHelper {
    private final AuthDomainService authDomainService;
    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final UserDataMapper authDataMapper;
    private final UserKeycloakApplicationService keycloakApplicationService;
    private final RoleQueryHelper roleQueryHelper;
    private final String ROLE_NAME_USER = "user";
    private final UserRoleCreateHelper userRoleCreateHelper;

    @Transactional
    public UserCreatedEvent createUser(CreateUserCommand createUserCommand) {
        findUserWithEmail(createUserCommand.getEmail());
        findOrganization(createUserCommand.getOrganizationId());

        User user = authDataMapper.createUserCommandToUser(createUserCommand);
        user.setLinkedWithMicrosoft(false);
        user.setLinkedWithGoogle(false);

        UserCreatedEvent userCreatedEvent = authDomainService.createUser(user);
        saveUser(user);

        keycloakApplicationService.createUserByAdmin(createUserCommand);

        Role roleUser = roleQueryHelper.queryRoleByName(ROLE_NAME_USER);
        userRoleCreateHelper.persistUserRole(CreateUserRoleCommand.builder()
                .userId(user.getId().getValue())
                .roleId(roleUser.getId().getValue())
                .build());
        if (!createUserCommand.getRoleName().equals(ROLE_NAME_USER)) {
            Role assignedRole = roleQueryHelper.queryRoleByName(createUserCommand.getRoleName());
            userRoleCreateHelper.persistUserRole(CreateUserRoleCommand.builder()
                    .userId(user.getId().getValue())
                    .roleId(assignedRole.getId().getValue())
                    .build());
        }

        return userCreatedEvent;
    }

    @Transactional
    public UserCreatedEvent registerUser(RegisterUserCommand registerUserCommand) {
        findUserWithEmail(registerUserCommand.getEmail());

        User user = authDataMapper.registerUserCommandToUser(registerUserCommand);
        user.setLinkedWithMicrosoft(false);
        user.setLinkedWithGoogle(false);

        UserCreatedEvent userCreatedEvent = authDomainService.createUser(user);
        saveUser(user);

        keycloakApplicationService.registerUser(registerUserCommand);

        Role role = roleQueryHelper.queryRoleByName(ROLE_NAME_USER);
        userRoleCreateHelper.persistUserRole(CreateUserRoleCommand.builder()
                .userId(user.getId().getValue())
                .roleId(role.getId().getValue())
                .build());
        return userCreatedEvent;
    }


    @Transactional
    public UserCreatedEvent persistUserSocialLogin(CreateSocialLoginUserCommand createSocialLoginUserCommand) {
        findUserWithEmail(createSocialLoginUserCommand.getEmail());
        User user = authDataMapper.createSocialLoginUserCommandToUser(createSocialLoginUserCommand);
        UserCreatedEvent userCreatedEvent = authDomainService.createUser(user);
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

    private void findOrganization(UUID organizationId) {
        if (organizationId == null) {
            return;
        }
        Optional<Organization> organizationResult = organizationRepository.findById(new OrganizationId(organizationId));
        if (organizationResult.isPresent()) {
            log.warn("Not found organization with id: {}", organizationId);
            throw new AuthDomainException("Not found organization with id: " + organizationId);
        }
    }


    private void saveUser(User user) {
        User userResult = userRepository.save(user);
        if (userResult == null) {
            log.error("Could not create user!");
            throw new AuthDomainException("Could not create user!");
        }
        log.info("User is created with id: {}", userResult.getId().getValue());
    }
}
