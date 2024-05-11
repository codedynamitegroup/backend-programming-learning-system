package com.backend.programming.learning.system.course.service.dataaccess.organization_role.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.organization_role.mapper.OrganizationRoleDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.organization_role.repository.OrganizationRoleJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.OrganizationRole;
import com.backend.programming.learning.system.course.service.domain.entity.RoleMoodle;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRoleRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.RoleMoodleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrganizationRoleRepositoryImpl implements OrganizationRoleRepository {
    private final OrganizationRoleJpaRepository organizationRoleJpaRepository;
    private final OrganizationRoleDataAccessMapper organizationRoleDataAccessMapper;


    @Override
    public OrganizationRole save(OrganizationRole organizationRole) {
        return organizationRoleDataAccessMapper
                .organizationRoleEntityToOrganizationRole(organizationRoleJpaRepository
                        .save(organizationRoleDataAccessMapper
                                .organizationRoleToOrganizationRoleEntity(organizationRole)));
    }

    @Override
    public Optional<OrganizationRole> findById(UUID id) {
        return organizationRoleJpaRepository.findById(id)
                .map(organizationRoleDataAccessMapper::organizationRoleEntityToOrganizationRole);
    }

}
