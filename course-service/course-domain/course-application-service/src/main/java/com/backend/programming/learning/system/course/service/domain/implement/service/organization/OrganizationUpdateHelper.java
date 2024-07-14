package com.backend.programming.learning.system.course.service.domain.implement.service.organization;

import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.SyncOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.UpdateOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrganizationUpdateHelper {
    private final OrganizationRepository organizationRepository;

    @Transactional
    public void persistOrganization(UUID organizationId,UpdateOrganizationCommand updateOrganizationCommand) {
        Organization organization = getOrganization(organizationId);
        organization.setUpdatedAt(ZonedDateTime.now());
        if(updateOrganizationCommand.getDescription()!=null)
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
            String moodleUrl = updateOrganizationCommand.getMoodleUrl() + ":8081/webservice/rest/server.php";
            organization.setMoodleUrl(moodleUrl);
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
