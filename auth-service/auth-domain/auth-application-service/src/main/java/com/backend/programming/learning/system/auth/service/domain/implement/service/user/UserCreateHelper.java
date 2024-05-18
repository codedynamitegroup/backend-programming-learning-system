package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class UserCreateHelper {
    private final AuthDomainService authDomainService;
    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final UserDataMapper authDataMapper;
    private final UserKeycloakApplicationService keycloakApplicationService;

    public UserCreateHelper(AuthDomainService authDomainService, UserRepository userRepository, OrganizationRepository organizationRepository, UserDataMapper authDataMapper, UserKeycloakApplicationService keycloakApplicationService) {
        this.authDomainService = authDomainService;
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
        this.authDataMapper = authDataMapper;
        this.keycloakApplicationService = keycloakApplicationService;
    }

    @Transactional
    public UserCreatedEvent persistUser(CreateUserCommand createUserCommand) {
        findUserWithEmail(createUserCommand.getEmail());
        findOrganization(createUserCommand.getOrganizationId());
        User user = authDataMapper.createUserCommandToUser(createUserCommand);
        UserCreatedEvent userCreatedEvent = authDomainService.createUser(user);
        saveUser(user);
        keycloakApplicationService.createUser(createUserCommand);
        return userCreatedEvent;
    }

    @Transactional
    public UserCreatedEvent persistUserWithoutToken(CreateUserCommand createUserCommand) {
        findUserWithEmail(createUserCommand.getEmail());
        findOrganization(createUserCommand.getOrganizationId());
        User user = authDataMapper.createUserCommandToUser(createUserCommand);
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
