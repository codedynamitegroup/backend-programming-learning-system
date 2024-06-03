package com.backend.programming.learning.system.auth.service.dataaccess.role.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.role.entity.RoleEntity;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import org.springframework.stereotype.Component;

@Component
public class RoleDataAccessMapper {
    public RoleEntity roleToRoleEntity(Role role) {
        return RoleEntity.builder()
                .id(role.getId().getValue())
                .description(role.getDescription())
                .name(role.getName())
                .build();
    }

    public Role roleEntityToRole(RoleEntity roleEntity) {
        return Role.builder()
                .id(new RoleId(roleEntity.getId()))
                .description(roleEntity.getDescription())
                .name(roleEntity.getName())
                .build();
    }
}
