package com.backend.programming.learning.system.core.service.dataaccess.organization.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.organization.repository.OrganizationJpaRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class OrganizationRepositoryImpl implements OrganizationRepository {
    private final OrganizationJpaRepository organizationJpaRepository;
    private final OrganizationDataAccessMapper organizationDataAccessMapper;

    public OrganizationRepositoryImpl(OrganizationJpaRepository organizationJpaRepository,
                                      OrganizationDataAccessMapper organizationDataAccessMapper) {
        this.organizationJpaRepository = organizationJpaRepository;
        this.organizationDataAccessMapper = organizationDataAccessMapper;
    }

    @Override
    public Optional<Organization> findOrganization(UUID organizationId) {
        return organizationJpaRepository.findById(organizationId)
                .map(organizationDataAccessMapper::organizationEntityToOrganization);
    }
}
