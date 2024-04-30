package com.backend.programming.learning.system.auth.service.domain.implement.service.user_role;

import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role.DeleteUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRoleRepository;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class UserRoleDeleteHelper {
    private final UserRoleRepository userRoleRepository;

    public UserRoleDeleteHelper(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Transactional
    public void deleteUserRole(DeleteUserRoleCommand deleteUserRoleCommand) {
        Optional<UserRole> userRoleResult =
                userRoleRepository.findByRoleIdAndUserId(new RoleId(deleteUserRoleCommand.getRoleId()), new UserId(deleteUserRoleCommand.getUserId()));
        if (userRoleResult.isEmpty()) {
            log.warn("Could not find user role with role id: {} and user id: {}",
                    deleteUserRoleCommand.getRoleId(), deleteUserRoleCommand.getUserId());
            throw new AuthNotFoundException("Could not find user role with role id: " + deleteUserRoleCommand.getRoleId() +
                    " and user id: " + deleteUserRoleCommand.getUserId());
        }

        UserRole userRole = userRoleResult.get();
        userRoleRepository.deleteByRoleIdAndUserId(userRole.getRole().getId(), userRole.getUser().getId());
    }
}
