package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Role;
import com.backend.programming.learning.system.valueobject.RoleId;

import java.util.Optional;

public interface RoleRepository {
    Role save(Role user);

    Optional<Role> findById(RoleId userId);
}
