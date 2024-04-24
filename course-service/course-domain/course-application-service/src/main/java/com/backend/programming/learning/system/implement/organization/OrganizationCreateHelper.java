package com.backend.programming.learning.system.implement.organization;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.entity.Organization;
import com.backend.programming.learning.system.mapper.organization.OrganizationDataMapper;
import com.backend.programming.learning.system.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.ports.output.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrganizationCreateHelper {
    private final CourseDomainService courseDomainService;
    private final OrganizationRepository organizationRepository;
    private final CourseRepository courseRepository;
    private final OrganizationDataMapper organizationDataMapper;

    public Organization persistOrganization(CreateOrganizationCommand createOrganizationCommand) {
        Organization organization = organizationDataMapper.createOrganizationCommandToOrganization(createOrganizationCommand);
        courseDomainService.createOrganization(organization);
        Organization organizationResult = saveOrganization(organization);
        return organizationResult;
    }

    private Organization saveOrganization(Organization organization) {
        Organization savedOrganization = organizationRepository.saveOrganization(organization);
        if (savedOrganization == null) {
            log.error("Organization is not saved");
            throw new RuntimeException("Organization is not saved");
        }
        log.info("Organization is saved");
        return savedOrganization;
    }
}
