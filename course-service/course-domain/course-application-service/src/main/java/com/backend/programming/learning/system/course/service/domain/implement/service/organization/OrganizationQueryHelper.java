package com.backend.programming.learning.system.course.service.domain.implement.service.organization;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.organization.QueryAllOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrganizationQueryHelper {
    private final OrganizationRepository organizationRepository;

    public Organization queryOrganizationById(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findOrganizationById(organizationId);
        if (organization == null) {
            log.error("Organization is not found");
            throw new RuntimeException("Organization is not found");
        }
        log.info("Organization is found");
        return organization.get();
    }

    public QueryAllOrganizationResponse queryAllOrganization() {
        return new QueryAllOrganizationResponse(organizationRepository.findAllOrganization());
    }
}
