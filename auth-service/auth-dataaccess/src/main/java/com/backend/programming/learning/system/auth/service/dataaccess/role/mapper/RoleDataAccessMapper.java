package com.backend.programming.learning.system.auth.service.dataaccess.role.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.role.entity.RoleEntity;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class RoleDataAccessMapper {

    public RoleEntity roleToRoleEntity(Role role) {
        return RoleEntity.builder()
                .id(role.getId().getValue())
                .organizationId(role.getOrganizationId().getValue())
                .createdBy(role.getCreatedBy().getValue())
                .updatedBy(role.getUpdatedBy().getValue())
                .description(role.getDescription())
                .name(role.getName())
                .createdAt(role.getCreatedAt())
                .updatedAt(role.getUpdatedAt())
                .build();
    }

    public Role roleEntityToRole(RoleEntity roleEntity) {
        return Role.builder()
                .id(new RoleId(roleEntity.getId()))
                .organizationId(new OrganizationId(roleEntity.getOrganizationId()))
                .createdBy(new UserId(roleEntity.getCreatedBy()))
                .updatedBy(new UserId(roleEntity.getUpdatedBy()))
                .description(roleEntity.getDescription())
                .name(roleEntity.getName())
                .createdAt(roleEntity.getCreatedAt())
                .updatedAt(roleEntity.getUpdatedAt())
                .build();
    }
}
