package com.backend.programming.learning.system.implement.organization;

import com.backend.programming.learning.system.entity.Organization;
import com.backend.programming.learning.system.exception.OrganizationNotFoundException;
import com.backend.programming.learning.system.ports.output.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrganizationDeleteHelper {
    private final OrganizationRepository organizationRepository;
    @Transactional(readOnly = true)
    public void deleteOrganizationById(UUID organizationId) {
        checkOrganizationExists(organizationId);
        organizationRepository.deleteOrganizationById(organizationId);
    }

    private void checkOrganizationExists(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findOrganizationById(organizationId);
        if (organization.isEmpty()) {
            log.warn("Could not find organization with id: {}", organizationId);
            throw new OrganizationNotFoundException("Could not find organization with id: " + organizationId);
        }
    }
}
