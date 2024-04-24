package com.backend.programming.learning.system.auth.service.domain.implement.role;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.role.CreateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.mapper.RoleDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.RoleRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class RoleCreateHelper {
    private final AuthDomainService authDomainService;
    private final RoleRepository roleRepository;
    private final OrganizationRepository organizationRepository;
    private final RoleDataMapper roleDataMapper;
    private final UserRepository userRepository;

    public RoleCreateHelper(AuthDomainService authDomainService, RoleRepository roleRepository, OrganizationRepository organizationRepository, RoleDataMapper roleDataMapper, UserRepository userRepository) {
        this.authDomainService = authDomainService;
        this.roleRepository = roleRepository;
        this.organizationRepository = organizationRepository;
        this.roleDataMapper = roleDataMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public Role persistRole(CreateRoleCommand createRoleCommand) {
        User createdBy = getUser(createRoleCommand.getCreatedBy());
        Organization organization = getOrganization(createRoleCommand.getOrganizationId());
        Role role = roleDataMapper.createRoleCommandToRole(createRoleCommand);
        role.setOrganization(organization);
        role.setCreatedBy(createdBy);
        role.setUpdatedBy(createdBy);
        authDomainService.createRole(role);
        return saveRole(role);
    }

    private Organization getOrganization(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findById(new OrganizationId(organizationId));
        if (organization.isEmpty()) {
            log.warn("Could not find organization with id: {}", organizationId);
            throw new AuthNotFoundException("Could not find organization with id: " + organizationId);
        }
        return organization.get();
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findById(new UserId(userId));
        if (user.isEmpty()) {
            log.error("User with id: {} could not be found!", userId);
            throw new AuthDomainException("User with id: " + userId + " could not be found!");
        }
        return user.get();
    }


    private Role saveRole(Role role) {
        Role roleResult = roleRepository.save(role);
        if (roleResult == null) {
            log.error("Could not save auth!");
            throw new AuthDomainException("Could not save auth!");
        }
        log.info("Role is saved with id: {}", roleResult.getId().getValue());
        return roleResult;
    }
}
