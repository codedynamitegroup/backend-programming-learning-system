package com.backend.programming.learning.system.auth.service.dataaccess.organization.adapter;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrganizationRepositoryImpl implements OrganizationRepository {
    @Override
    public Organization save(Organization organization) {
        return null;
    }

    @Override
    public Optional<Organization> findById(OrganizationId organizationId) {
        return Optional.empty();
    }
}
