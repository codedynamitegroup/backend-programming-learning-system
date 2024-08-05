package com.backend.programming.learning.system.auth.service.domain.implement.service.organization;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role.DeleteUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.implement.service.role.RoleQueryHelper;
import com.backend.programming.learning.system.auth.service.domain.implement.service.user_role.UserRoleCreateHelper;
import com.backend.programming.learning.system.auth.service.domain.implement.service.user_role.UserRoleQueryHelper;
import com.backend.programming.learning.system.auth.service.domain.mapper.OrganizationDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.RoleKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRoleRepository;
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
public class OrganizationCreateHelper {
    private final AuthDomainService authDomainService;
    private final OrganizationRepository organizationRepository;
    private final OrganizationDataMapper organizationDataMapper;
    private final UserRepository userRepository;
    private final UserRoleQueryHelper userRoleQueryHelper;
    private final String ROLE_ORG_ADMIN = "admin_moodle";
    private final String ROLE_NAME_USER = "user";
    private final RoleQueryHelper roleQueryHelper;
    private final UserRoleRepository userRoleRepository;
    private final RoleKeycloakApplicationService roleKeycloakApplicationService;
    private final UserRoleCreateHelper userRoleCreateHelper;

    @Transactional
    public OrganizationCreatedEvent persistOrganization(CreateOrganizationCommand createOrganizationCommand) {
        User createdBy = getUserById(createOrganizationCommand.getCreatedBy());
        if (createdBy.getOrganization() != null) {
            log.error("User with userId: {} already has organization!", createdBy.getId().getValue());
            throw new AuthDomainException("User with userId: " + createdBy.getId().getValue() + " already has organization!");
        }
        Organization organization = organizationDataMapper.createOrganizationCommandToOrganization(createOrganizationCommand);
        organization.setCreatedBy(createdBy);
        organization.setUpdatedBy(createdBy);

        OrganizationCreatedEvent organizationCreatedEvent = authDomainService.createOrganization(organization);
        Organization organizationCreated = saveOrganization(organization);

        createdBy.setOrganization(organizationCreated);
        saveUser(createdBy);

        UserRole userRole = userRoleQueryHelper.findByUserIdAndRoleIsNotUser(createdBy.getId().getValue());

        if (userRole != null) { // If user has role different from role user
            String roleName = userRole.getRole().getName();
            if (!roleName.equals(ROLE_ORG_ADMIN)) {  // Update role
                Role role = roleQueryHelper.queryRoleByName(ROLE_ORG_ADMIN);
                userRole.setRole(role);
                userRoleRepository.save(userRole);
                roleKeycloakApplicationService.removeRole(createdBy.getEmail(), roleName);
                roleKeycloakApplicationService.assignRole(createdBy.getEmail(), ROLE_ORG_ADMIN); //assign new role
            }
        } else { // User only have role user
            Role role = roleQueryHelper.queryRoleByName(ROLE_ORG_ADMIN);
            roleKeycloakApplicationService.removeRole(createdBy.getEmail(), ROLE_NAME_USER); //remove role user in keycloak
            userRoleCreateHelper.persistUserRole(CreateUserRoleCommand.builder()
                    .roleId(role.getId().getValue())
                    .userId(createdBy.getId().getValue())
                    .build());
        }
        return organizationCreatedEvent;
    }

    private User getUserById(UUID userId) {
        Optional<User> user = userRepository.findById(new UserId(userId));
        if (user.isEmpty()) {
            log.error("User with userId: {} could not be found!", userId);
            throw new AuthDomainException("User with userId: " + userId + " could not be found!");
        }
        return user.get();
    }

    private Organization saveOrganization(Organization organization) {
        Organization organizationResult = organizationRepository.save(organization);
        if (organizationResult == null) {
            log.error("Could not create organization!");
            throw new AuthDomainException("Could not create organization!");
        }
        log.info("Organization is created with id: {}", organizationResult.getId().getValue());
        return organizationResult;
    }

    private User saveUser(User user) {
        User userResult = userRepository.save(user);
        if (userResult == null) {
            log.error("Could not create user!");
            throw new AuthDomainException("Could not create user!");
        }
        log.info("Organization is created with id: {}", userResult.getId().getValue());
        return userResult;
    }
}
