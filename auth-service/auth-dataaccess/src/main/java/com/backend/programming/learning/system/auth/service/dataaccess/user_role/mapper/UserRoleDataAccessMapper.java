package com.backend.programming.learning.system.auth.service.dataaccess.user_role.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.role.entity.RoleEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.role.repository.RoleJpaRepository;
import com.backend.programming.learning.system.auth.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.auth.service.dataaccess.user_role.entity.UserRoleEntity;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.auth.service.domain.valueobject.UserRoleId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class UserRoleDataAccessMapper {
    private final RoleJpaRepository roleJpaRepository;
    private final UserJpaRepository userJpaRepository;

    public UserRoleDataAccessMapper(RoleJpaRepository roleJpaRepository, UserJpaRepository userJpaRepository) {
        this.roleJpaRepository = roleJpaRepository;
        this.userJpaRepository = userJpaRepository;
    }

    public UserRoleEntity userRoleToUserRoleEntity(UserRole userRole) {
        RoleEntity roleEntity = roleJpaRepository.findById(userRole.getRoleId().getValue())
                .orElseThrow(() -> new RuntimeException("Role with id: " + userRole.getRoleId().getValue() + " could not be found!"));
        UserEntity userEntity = userJpaRepository.findById(userRole.getUserId().getValue())
                .orElseThrow(() -> new RuntimeException("User with id: " + userRole.getUserId().getValue() + " could not be found!"));
        UserEntity createdBy = userJpaRepository.findById(userRole.getCreatedBy().getValue())
                .orElseThrow(() -> new RuntimeException("User with id: " + userRole.getCreatedBy().getValue() + " could not be found!"));
        UserEntity updatedBy = userJpaRepository.findById(userRole.getUpdatedBy().getValue())
                .orElseThrow(() -> new RuntimeException("User with id: " + userRole.getUpdatedBy().getValue() + " could not be found!"));
        return UserRoleEntity.builder()
                .id(userRole.getId().getValue())
                .role(roleEntity)
                .user(userEntity)
                .createdAt(userRole.getCreatedAt())
                .updatedAt(userRole.getUpdatedAt())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .isActive(userRole.isActive())
                .name(userRole.getName())
                .build();
    }

    public UserRole userRoleEntityToUserRole(UserRoleEntity userRoleEntity) {
        return UserRole.builder()
                .id(new UserRoleId(userRoleEntity.getId()))
                .roleId(new RoleId(userRoleEntity.getRole().getId()))
                .userId(new UserId(userRoleEntity.getUser().getId()))
                .createdAt(userRoleEntity.getCreatedAt())
                .updatedAt(userRoleEntity.getUpdatedAt())
                .createdBy(new UserId(userRoleEntity.getCreatedBy().getId()))
                .updatedBy(new UserId(userRoleEntity.getUpdatedBy().getId()))
                .isActive(userRoleEntity.isActive())
                .name(userRoleEntity.getName())
                .build();
    }
}
