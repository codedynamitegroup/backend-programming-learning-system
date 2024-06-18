package com.backend.programming.learning.system.auth.service.domain.implement.service.organization;

import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryOrganizationByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrganizationQueryHelper {
    private final OrganizationRepository organizationRepository;

    public OrganizationQueryHelper(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }


    @Transactional(readOnly = true)
    public Organization queryOrganization(UUID organizationId) {
        Optional<Organization> organizationResult =
                organizationRepository.findByIdAndIsDeletedTrueOrFalse(new OrganizationId(organizationId));
        if (organizationResult.isEmpty()) {
            log.warn("Could not find organization with id: {}", organizationId);
            throw new AuthNotFoundException("Could not find organization with id: " +
                    organizationId);
        }
        return organizationResult.get();
    }

    @Transactional(readOnly = true)
    public Page<Organization> queryAllOrganizations(Integer pageNo, Integer pageSize, String searchName) {
        return organizationRepository.findAll(pageNo, pageSize, searchName);
    }

}





















