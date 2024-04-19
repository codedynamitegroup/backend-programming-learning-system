package com.backend.programming.learning.system.auth.service.domain.implement.user_role;

import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRoleRepository;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class UserRoleQueryHelper {
    private final UserRoleRepository userRoleRepository;

    public UserRoleQueryHelper(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Transactional(readOnly = true)
    public UserRole queryUserRole(UUID roleId, UUID userId) {
        Optional<UserRole> userRoleResult =
                userRoleRepository.findByRoleIdAndUserId(new RoleId(roleId), new UserId(userId));
        if (userRoleResult.isEmpty()) {
            log.warn("Could not find user role with role id: {} and user id: {}",
                    roleId, userId);
            throw new AuthNotFoundException("Could not find user role with role id: " + roleId +
                    " and user id: " + userId);
        }
        return userRoleResult.get();
    }
}





















