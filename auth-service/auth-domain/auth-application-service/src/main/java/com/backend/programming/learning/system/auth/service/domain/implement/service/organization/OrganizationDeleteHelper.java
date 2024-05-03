package com.backend.programming.learning.system.auth.service.domain.implement.service.organization;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.organization.DeleteOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class OrganizationDeleteHelper {
    private final AuthDomainService authDomainService;
    private final OrganizationRepository organizationRepository;
    public OrganizationDeleteHelper(AuthDomainService authDomainService, OrganizationRepository organizationRepository) {
        this.authDomainService = authDomainService;
        this.organizationRepository = organizationRepository;
    }

    @Transactional
    public OrganizationDeletedEvent deleteOrganization(DeleteOrganizationCommand deleteOrganizationCommand) {
        Optional<Organization> organizationResult =
                organizationRepository.findById(new OrganizationId(deleteOrganizationCommand.getOrganizationId()));
        if (organizationResult.isEmpty()) {
            log.warn("Could not find organization with id: {}", deleteOrganizationCommand.getOrganizationId());
            throw new AuthNotFoundException("Could not find organization with id: " +
                    deleteOrganizationCommand.getOrganizationId());
        }

        Organization organization = organizationResult.get();

        OrganizationDeletedEvent organizationDeletedEvent = authDomainService.deleteOrganization(organization);
        saveOrganization(organization);
        return organizationDeletedEvent;
    }

    private Organization saveOrganization(Organization organization) {
        Organization organizationResult = organizationRepository.save(organization);
        if (organizationResult == null) {
            log.error("Could not delete organization!");
            throw new AuthDomainException("Could not delete organization!");
        }
        log.info("Organization is deleted with id: {}", organizationResult.getId().getValue());
        return organizationResult;
    }
}
