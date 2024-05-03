package com.backend.programming.learning.system.auth.service.dataaccess.organization.adapter;

import com.backend.programming.learning.system.auth.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.organization.repository.OrganizationJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrganizationRepositoryImpl implements OrganizationRepository {
    private final OrganizationDataAccessMapper organizationDataAccessMapper;
    private final OrganizationJpaRepository organizationJpaRepository;

    public OrganizationRepositoryImpl(OrganizationDataAccessMapper organizationDataAccessMapper, OrganizationJpaRepository organizationJpaRepository) {
        this.organizationDataAccessMapper = organizationDataAccessMapper;
        this.organizationJpaRepository = organizationJpaRepository;
    }

    @Override
    public Organization save(Organization organization) {
        return organizationDataAccessMapper
                .organizationEntityToOrganization(organizationJpaRepository
                        .save(organizationDataAccessMapper.organizationToOrganizationEntity(organization)));
    }

    @Override
    public Optional<Organization> findById(OrganizationId organizationId) {
        return organizationJpaRepository.findByIdAndIsDeletedFalse(organizationId.getValue())
                .map(organizationDataAccessMapper::organizationEntityToOrganization);
    }

    @Override
    public Optional<Organization> findByIdAndIsDeletedTrue(OrganizationId organizationId) {
        return organizationJpaRepository.findByIdAndIsDeletedTrue(organizationId.getValue())
                .map(organizationDataAccessMapper::organizationEntityToOrganization);
    }

    @Override
    public Page<Organization> findAll(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        return organizationJpaRepository.findAllByIsDeletedFalse(paging)
                .map(organizationDataAccessMapper::organizationEntityToOrganization);
    }
}
