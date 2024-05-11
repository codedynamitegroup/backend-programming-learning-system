package com.backend.programming.learning.system.auth.service.domain.implement.service.role;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.RoleRepository;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class RoleQueryHelper {
    private final RoleRepository roleRepository;

    public RoleQueryHelper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    public Role queryRole(UUID roleId) {
        Optional<Role> roleResult =
                roleRepository.findById(new RoleId(roleId));
        if (roleResult.isEmpty()) {
            log.warn("Could not find role with id: {}", roleId);
            throw new AuthNotFoundException("Could not find role with role id: " +
                    roleId);
        }
        return roleResult.get();
    }

    @Transactional(readOnly = true)
    public Page<Role> queryAllRoles(Integer page, Integer size) {
        return roleRepository.findAll(page, size);
    }
}





















