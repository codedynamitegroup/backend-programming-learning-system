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
    private final OrganizationDataAccessMapper organizationDataAccessMapper;

    public RoleDataAccessMapper(UserDataAccessMapper userDataAccessMapper, OrganizationDataAccessMapper organizationDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
        this.organizationDataAccessMapper = organizationDataAccessMapper;
    }

    public RoleEntity roleToRoleEntity(Role role) {
        return RoleEntity.builder()
                .id(role.getId().getValue())
                .organization(
                        OrganizationEntity.builder()
                                .id(role.getOrganization().getId().getValue())
                                .build()
                )
                .createdBy(userDataAccessMapper.userToUserEntity(role.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userToUserEntity(role.getUpdatedBy()))
                .description(role.getDescription())
                .name(role.getName())
                .createdAt(role.getCreatedAt())
                .updatedAt(role.getUpdatedAt())
                .build();
    }

    public Role roleEntityToRole(RoleEntity roleEntity) {
        return Role.builder()
                .id(new RoleId(roleEntity.getId()))
                .organization(organizationDataAccessMapper.organizationEntityToOrganization(roleEntity.getOrganization()))
                .createdBy(userDataAccessMapper.userEntityToUser(roleEntity.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userEntityToUser(roleEntity.getUpdatedBy()))
                .description(roleEntity.getDescription())
                .name(roleEntity.getName())
                .createdAt(roleEntity.getCreatedAt())
                .updatedAt(roleEntity.getUpdatedAt())
                .build();
    }
}
