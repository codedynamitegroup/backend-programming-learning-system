package com.backend.programming.learning.system.auth.service.dataaccess.user_role.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.role.entity.RoleEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.role.mapper.RoleDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.user_role.entity.UserRoleEntity;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.auth.service.domain.valueobject.UserRoleId;
import org.springframework.stereotype.Component;

@Component
public class UserRoleDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;
    private final RoleDataAccessMapper roleDataAccessMapper;

    public UserRoleDataAccessMapper(UserDataAccessMapper userDataAccessMapper, RoleDataAccessMapper roleDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
        this.roleDataAccessMapper = roleDataAccessMapper;
    }

    public UserRoleEntity userRoleToUserRoleEntity(UserRole userRole) {
        return UserRoleEntity.builder()
                .id(userRole.getId().getValue())
                .role(
                        RoleEntity.builder()
                                .id(userRole.getRole().getId().getValue())
                                .build()
                )
                .user(userDataAccessMapper.userToUserEntity(userRole.getUser()))
                .createdAt(userRole.getCreatedAt())
                .updatedAt(userRole.getUpdatedAt())
                .createdBy(userDataAccessMapper.userToUserEntity(userRole.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userToUserEntity(userRole.getUpdatedBy()))
                .build();
    }

    public UserRole userRoleEntityToUserRole(UserRoleEntity userRoleEntity) {
        return UserRole.builder()
                .id(new UserRoleId(userRoleEntity.getId()))
                .role(roleDataAccessMapper.roleEntityToRole(userRoleEntity.getRole()))
                .user(userDataAccessMapper.userEntityToUser(userRoleEntity.getUser()))
                .createdAt(userRoleEntity.getCreatedAt())
                .updatedAt(userRoleEntity.getUpdatedAt())
                .createdBy(userDataAccessMapper.userEntityToUser(userRoleEntity.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userEntityToUser(userRoleEntity.getUpdatedBy()))
                .build();
    }
}
