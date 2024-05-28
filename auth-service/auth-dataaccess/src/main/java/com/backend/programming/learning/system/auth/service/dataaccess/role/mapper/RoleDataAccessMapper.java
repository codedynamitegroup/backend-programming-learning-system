package com.backend.programming.learning.system.auth.service.dataaccess.role.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.role.entity.RoleEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class RoleDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;

    public RoleDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

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
