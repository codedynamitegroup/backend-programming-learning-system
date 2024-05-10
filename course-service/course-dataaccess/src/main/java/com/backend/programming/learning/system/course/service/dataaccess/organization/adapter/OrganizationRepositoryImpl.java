package com.backend.programming.learning.system.course.service.dataaccess.organization.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.organization.repository.OrganizationJpaRepository;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.organization.OrganizationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrganizationRepositoryImpl implements OrganizationRepository {
    private final OrganizationJpaRepository organizationJpaRepository;
    private final OrganizationDataAccessMapper organizationDataAccessMapper;

    @Override
    public Optional<Organization> findOrganizationByName(String name) {
        return organizationJpaRepository.findOrganizationByName(name)
                .map(organizationDataAccessMapper::organizationEntityToOrganization);
    }

    @Override
    public Optional<Organization> findOrganizationByMoodleUrl(String moodleUrl) {
        return organizationJpaRepository.findByMoodleUrl(moodleUrl)
                .map(organizationDataAccessMapper::organizationEntityToOrganization);
    }

    @Override
    public Organization saveOrganization(Organization organization) {
        return organizationDataAccessMapper.organizationEntityToOrganization(
                organizationJpaRepository.save(
                        organizationDataAccessMapper.organizationToOrganizationEntity(organization)
                )
        );
    }

    @Override
    public Optional<Organization> findOrganizationById(UUID organizationId) {
        return organizationJpaRepository.findById(organizationId)
                .map(organizationDataAccessMapper::organizationEntityToOrganization);
    }

    @Override
    public List<OrganizationResponseEntity> findAllOrganization() {
        return organizationDataAccessMapper.organizationEntityListToOrganizationList(
                organizationJpaRepository.findAll()
        );
    }

    @Override
    public void deleteOrganizationById(UUID organizationId) {
        organizationJpaRepository.deleteById(organizationId);
    }
}
