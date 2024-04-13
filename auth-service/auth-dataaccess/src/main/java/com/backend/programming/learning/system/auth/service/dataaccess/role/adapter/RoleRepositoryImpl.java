package com.backend.programming.learning.system.auth.service.dataaccess.role.adapter;

import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.RoleRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleRepositoryImpl implements RoleRepository {
    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public Optional<Role> findById(RoleId roleId) {
        return Optional.empty();
    }

    @Override
    public void deleteById(RoleId roleId) {

    }
}
