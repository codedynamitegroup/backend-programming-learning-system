package com.backend.programming.learning.system.course.service.domain.implement.service.organization;

import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.SyncOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.UpdateOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrganizationUpdateHelper {
    private final OrganizationRepository organizationRepository;

    @Transactional
    public void persistOrganization(UpdateOrganizationCommand updateOrganizationCommand) {
        Organization organization = getOrganization(updateOrganizationCommand.getOrganizationId());
        {
            organization.setDescription(updateOrganizationCommand.getDescription());
        }

        if(updateOrganizationCommand.getName() != null)
        {
            organization.setName(updateOrganizationCommand.getName());
        }

        if(updateOrganizationCommand.getApiKey() != null)
        {
            organization.setApiKey(updateOrganizationCommand.getApiKey());
        }

        if(updateOrganizationCommand.getMoodleUrl() != null)
        {
            organization.setMoodleUrl(updateOrganizationCommand.getMoodleUrl());
        }
        organizationRepository.saveOrganization(organization);
    }


    @Transactional
    public void synchronizeDataMoodle(UUID organizationId,SyncOrganizationCommand syncOrganizationCommand) {
        Organization organization = getOrganization(organizationId);
        {
            organization.setApiKey(syncOrganizationCommand.getApiKey());
            organization.setMoodleUrl(syncOrganizationCommand.getMoodleUrl());
        }
        organizationRepository.saveOrganization(organization);
    }

    private Organization getOrganization(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findOrganizationById(organizationId);
        if (organization == null) {
            log.error("Organization is not found");
            throw new RuntimeException("Organization is not found");
        }
        log.info("Organization is found");
        return organization.get();
    }
}
