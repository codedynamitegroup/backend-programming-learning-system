package com.backend.programming.learning.system.auth.service.dataaccess.role.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.organization.repository.OrganizationJpaRepository;
import com.backend.programming.learning.system.auth.service.dataaccess.role.entity.RoleEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class RoleDataAccessMapper {
    private final OrganizationJpaRepository organizationJpaRepository;
    private final UserJpaRepository userJpaRepository;

    public RoleDataAccessMapper(OrganizationJpaRepository organizationJpaRepository, UserJpaRepository userJpaRepository) {
        this.organizationJpaRepository = organizationJpaRepository;
        this.userJpaRepository = userJpaRepository;
    }

    public RoleEntity roleToRoleEntity(Role role) {
        OrganizationEntity organization = organizationJpaRepository.findById(role.getOrganizationId().getValue())
                .orElseThrow(() -> new RuntimeException("Organization with id: " + role.getOrganizationId().getValue() + " could not be found!"));
        UserEntity createdBy = userJpaRepository.findById(role.getCreatedBy().getValue())
                .orElseThrow(() -> new RuntimeException("User with id: " + role.getCreatedBy().getValue() + " could not be found!"));
        UserEntity updatedBy = userJpaRepository.findById(role.getUpdatedBy().getValue())
                .orElseThrow(() -> new RuntimeException("User with id: " + role.getUpdatedBy().getValue() + " could not be found!"));
        return RoleEntity.builder()
                .id(role.getId().getValue())
                .organization(organization)
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .description(role.getDescription())
                .name(role.getName())
                .createdAt(role.getCreatedAt())
                .updatedAt(role.getUpdatedAt())
                .build();
    }

    public Role roleEntityToRole(RoleEntity roleEntity) {
        return Role.builder()
                .id(new RoleId(roleEntity.getId()))
                .organizationId(new OrganizationId(roleEntity.getOrganization().getId()))
                .createdBy(new UserId(roleEntity.getCreatedBy().getId()))
                .updatedBy(new UserId(roleEntity.getUpdatedBy().getId()))
                .description(roleEntity.getDescription())
                .name(roleEntity.getName())
                .createdAt(roleEntity.getCreatedAt())
                .updatedAt(roleEntity.getUpdatedAt())
                .build();
    }
}
