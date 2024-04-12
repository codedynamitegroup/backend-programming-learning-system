package com.backend.programming.learning.system.auth.service.domain.ports.output.repository;

import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;

public interface UserRoleRepository {
    UserRole save(UserRole userRole);
}
