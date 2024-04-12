package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.mapper.RoleDataMapper;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.RoleRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class RoleCreateHelper {
    private final AuthDomainService authDomainService;
    private final RoleRepository roleRepository;
    private final RoleDataMapper roleDataMapper;

    public RoleCreateHelper(AuthDomainService authDomainService, RoleRepository roleRepository, RoleDataMapper roleDataMapper) {
        this.authDomainService = authDomainService;
        this.roleRepository = roleRepository;
        this.roleDataMapper = roleDataMapper;
    }

    @Transactional
    public Role persistRole(CreateRoleCommand createRoleCommand) {
        Role role = roleDataMapper.createRoleCommandToRole(createRoleCommand);
        authDomainService.createRole(role);
        return saveRole(role);
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
