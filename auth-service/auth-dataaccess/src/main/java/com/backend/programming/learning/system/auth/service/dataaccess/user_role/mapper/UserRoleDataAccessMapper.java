package com.backend.programming.learning.system.auth.service.dataaccess.user_role.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.user_role.entity.UserRoleEntity;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.auth.service.domain.valueobject.UserRoleId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class UserRoleDataAccessMapper {
    public UserRoleEntity userRoleToUserRoleEntity(UserRole userRole) {
        return UserRoleEntity.builder()
                .id(userRole.getId().getValue())
                .roleId(userRole.getRoleId().getValue())
                .userId(userRole.getUserId().getValue())
                .createdAt(userRole.getCreatedAt())
                .updatedAt(userRole.getUpdatedAt())
                .createdBy(userRole.getCreatedBy().getValue())
                .updatedBy(userRole.getUpdatedBy().getValue())
                .isActive(userRole.isActive())
                .name(userRole.getName())
                .build();
    }

    public UserRole userRoleEntityToUserRole(UserRoleEntity userRoleEntity) {
        return UserRole.builder()
                .id(new UserRoleId(userRoleEntity.getId()))
                .roleId(new RoleId(userRoleEntity.getRoleId()))
                .userId(new UserId(userRoleEntity.getUserId()))
                .createdAt(userRoleEntity.getCreatedAt())
                .updatedAt(userRoleEntity.getUpdatedAt())
                .createdBy(new UserId(userRoleEntity.getCreatedBy()))
                .updatedBy(new UserId(userRoleEntity.getUpdatedBy()))
                .isActive(userRoleEntity.isActive())
                .name(userRoleEntity.getName())
                .build();
    }
}
