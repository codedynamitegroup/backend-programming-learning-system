package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserRoleDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class UserRoleCreateHelper {
    private final AuthDomainService authDomainService;
    private final UserRoleRepository userRoleRepository;
    private final UserRoleDataMapper userRoleDataMapper;

    public UserRoleCreateHelper(AuthDomainService authDomainService, UserRoleRepository userRoleRepository, UserRoleDataMapper userRoleDataMapper) {
        this.authDomainService = authDomainService;
        this.userRoleRepository = userRoleRepository;
        this.userRoleDataMapper = userRoleDataMapper;
    }

    @Transactional
    public UserRole persistUserRole(CreateUserRoleCommand createUserRoleCommand) {
        UserRole userRole = userRoleDataMapper.createUserRoleCommandToUserRole(createUserRoleCommand);
        authDomainService.createUserRole(userRole);
        return saveUserRole(userRole);
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
