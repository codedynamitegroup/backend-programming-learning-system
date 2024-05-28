package com.backend.programming.learning.system.auth.service.domain.implement.service.role;

import com.backend.programming.learning.system.auth.service.domain.dto.method.update.organization.UpdateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.role.UpdateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.mapper.RoleDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.RoleRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
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
public class RoleUpdateHelper {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public RoleUpdateHelper(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }


    @Transactional
    public Role persistRole(UpdateRoleCommand updateRoleCommand) {
        Role role = getRole(updateRoleCommand.getRoleId());
        User updateBy = getUser(updateRoleCommand.getUpdatedBy());

        if (updateRoleCommand.getName() != null) {
            role.setName(updateRoleCommand.getName());
        }

        if (updateRoleCommand.getDescription() != null) {
            role.setDescription(updateRoleCommand.getDescription());
        }

        return saveRole(role);
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
            log.warn("Role with id: {} not found", roleId);
            throw new AuthNotFoundException("Could not find role with id: " + roleId);
        }
        return role.get();
    }

    private Role saveRole(Role role) {
        Role roleResult = roleRepository.save(role);
        if (roleResult == null) {
            log.error("Could not update role!");
            throw new AuthDomainException("Could not update role!");
        }
        log.info("Role is updated with id: {}", roleResult.getId().getValue());
        return roleResult;
    }
}
