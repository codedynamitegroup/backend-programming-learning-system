package com.backend.programming.learning.system.course.service.dataaccess.organization.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.organization.repository.OrganizationJpaRepository;
import com.backend.programming.learning.system.entity.Organization;
import com.backend.programming.learning.system.ports.output.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrganizationRepositoryImpl implements OrganizationRepository {
    private final OrganizationJpaRepository organizationJpaRepository;
    private final OrganizationDataAccessMapper organizationDataAccessMapper;
    @Override
    public Organization saveOrganization(Organization organization) {
        return null;
    }

    @Override
    public Optional<Organization> findOrganization(UUID organizationId) {
        return organizationJpaRepository.findById(organizationId)
                .map(organizationDataAccessMapper::organizationEntityToOrganization);
    }
}
