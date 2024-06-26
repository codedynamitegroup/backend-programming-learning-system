package com.backend.programming.learning.system.auth.service.domain.ports.output.repository;

import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.auth.service.domain.valueobject.UserRoleId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.util.Optional;
import java.util.UUID;

public interface UserRoleRepository {
    UserRole save(UserRole userRole);
    Optional<UserRole> findByRoleIdAndUserId(RoleId roleId, UserId userId);
    void deleteByRoleIdAndUserId(RoleId roleId, UserId userId);
    void deleteByRoleId(RoleId roleId);
    Optional<UserRole> findById(UserRoleId userRoleId);
    Optional<UserRole> findByUserIdAndRoleIsNotUser(UserId userId);
}
