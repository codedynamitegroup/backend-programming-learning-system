package com.backend.programming.learning.system.auth.service.domain.ports.output.repository;

import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {
    Role save(Role role);
    Optional<Role> findById(RoleId roleId);
    void deleteById(RoleId roleId);
}
