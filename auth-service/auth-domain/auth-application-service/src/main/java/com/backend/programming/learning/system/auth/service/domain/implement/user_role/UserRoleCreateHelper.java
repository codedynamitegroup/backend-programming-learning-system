package com.backend.programming.learning.system.auth.service.domain.implement.user_role;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserRoleDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRoleRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class UserRoleCreateHelper {
    private final AuthDomainService authDomainService;
    private final UserRoleRepository userRoleRepository;
    private final UserRoleDataMapper userRoleDataMapper;
    private final UserRepository userRepository;


    public UserRoleCreateHelper(AuthDomainService authDomainService, UserRoleRepository userRoleRepository, UserRoleDataMapper userRoleDataMapper, UserRepository userRepository) {
        this.authDomainService = authDomainService;
        this.userRoleRepository = userRoleRepository;
        this.userRoleDataMapper = userRoleDataMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public UserRole persistUserRole(CreateUserRoleCommand createUserRoleCommand) {
        UserRole userRole = userRoleDataMapper.createUserRoleCommandToUserRole(createUserRoleCommand);
        checkUserExist(userRole.getCreatedBy().getId().getValue());
        checkUserExist(userRole.getUpdatedBy().getId().getValue());
        authDomainService.createUserRole(userRole);
        return saveUserRole(userRole);
    }

    private void checkUserExist(UUID userId) {
        Optional<User> user = userRepository.findById(new UserId(userId));
        if (user.isEmpty()) {
            log.error("User with id: {} could not be found!", userId);
            throw new AuthDomainException("User with id: " + userId + " could not be found!");
        }
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
