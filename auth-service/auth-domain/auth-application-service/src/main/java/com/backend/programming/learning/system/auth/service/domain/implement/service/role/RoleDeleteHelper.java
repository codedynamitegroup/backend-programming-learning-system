package com.backend.programming.learning.system.auth.service.domain.implement.service.role;

import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.role.DeleteRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.RoleRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRoleRepository;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class RoleDeleteHelper {
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    public RoleDeleteHelper(RoleRepository roleRepository, UserRoleRepository userRoleRepository) {
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Transactional
    public void deleteRole(DeleteRoleCommand deleteRoleCommand) {
        Optional<Role> roleResult =
                roleRepository.findById(new RoleId(deleteRoleCommand.getRoleId()));
        if (roleResult.isEmpty()) {
            log.warn("Could not find role with id: {}", deleteRoleCommand.getRoleId());
            throw new AuthNotFoundException("Could not find role with id: " +
                    deleteRoleCommand.getRoleId());
        }

        Role role = roleResult.get();
        userRoleRepository.deleteByRoleId(role.getId());
        roleRepository.deleteById(role.getId());
    }
}
