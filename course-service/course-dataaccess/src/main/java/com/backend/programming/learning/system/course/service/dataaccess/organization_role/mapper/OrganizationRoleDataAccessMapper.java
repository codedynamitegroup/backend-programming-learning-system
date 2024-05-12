package com.backend.programming.learning.system.course.service.dataaccess.organization_role.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.organization_role.entity.OrganizationRoleEntity;
import com.backend.programming.learning.system.course.service.dataaccess.role_moodle.entity.RoleMoodleEntity;
import com.backend.programming.learning.system.course.service.dataaccess.role_moodle.mapper.RoleMoodleDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.OrganizationRole;
import com.backend.programming.learning.system.course.service.domain.entity.RoleMoodle;
import com.backend.programming.learning.system.course.service.domain.valueobject.OrganizationRoleId;
import com.backend.programming.learning.system.course.service.domain.valueobject.RoleMoodleId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizationRoleDataAccessMapper {

    private final RoleMoodleDataAccessMapper roleMoodleDataAccessMapper;
    private final OrganizationDataAccessMapper organizationDataAccessMapper;

    public OrganizationRoleDataAccessMapper(RoleMoodleDataAccessMapper roleMoodleDataAccessMapper, OrganizationDataAccessMapper organizationDataAccessMapper) {
        this.roleMoodleDataAccessMapper = roleMoodleDataAccessMapper;
        this.organizationDataAccessMapper = organizationDataAccessMapper;
    }

    public OrganizationRoleEntity organizationRoleToOrganizationRoleEntity(OrganizationRole organizationRole) {
        RoleMoodleEntity roleMoodleEntity = roleMoodleDataAccessMapper.roleMoodleToRoleMoodleEntity(organizationRole.getRoleMoodle());
        OrganizationEntity organizationEntity = organizationDataAccessMapper.organizationToOrganizationEntity(organizationRole.getOrganization());
        return OrganizationRoleEntity.builder()
                .id(organizationRole.getId().getValue())
                .role(roleMoodleEntity)
                .organization(organizationEntity)
                .build();
    }

    public OrganizationRole organizationRoleEntityToOrganizationRole(OrganizationRoleEntity organizationRoleEntity) {
        RoleMoodle roleMoodle = roleMoodleDataAccessMapper.roleMoodleEntityToRoleMoodle(organizationRoleEntity.getRole());
        Organization organization = organizationDataAccessMapper.organizationEntityToOrganization(organizationRoleEntity.getOrganization());
        return OrganizationRole.builder()
                .id(new OrganizationRoleId(organizationRoleEntity.getId()))
                .roleMoodle(roleMoodle)
                .organization(organization)
                .build();
    }

    public List<OrganizationRole> organizationRoleToOrganizationRoleEntityList(List<OrganizationRoleEntity> organizationRoleList) {
        return organizationRoleList.stream()
                .map(this::organizationRoleEntityToOrganizationRole)
                .toList();
    }
}
