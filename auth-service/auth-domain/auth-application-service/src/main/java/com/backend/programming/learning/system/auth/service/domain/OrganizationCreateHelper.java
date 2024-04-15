package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.mapper.OrganizationDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class OrganizationCreateHelper {
    private final AuthDomainService authDomainService;
    private final OrganizationRepository organizationRepository;
    private final OrganizationDataMapper organizationDataMapper;

    public OrganizationCreateHelper(AuthDomainService authDomainService, OrganizationRepository organizationRepository, OrganizationDataMapper organizationDataMapper) {
        this.authDomainService = authDomainService;
        this.organizationRepository = organizationRepository;
        this.organizationDataMapper = organizationDataMapper;
    }

    @Transactional
    public Organization persistOrganization(CreateOrganizationCommand createOrganizationCommand) {
        Organization organization = organizationDataMapper.createOrganizationCommandToOrganization(createOrganizationCommand);
        authDomainService.createOrganization(organization);
        return saveOrganization(organization);
    }

    private Organization saveOrganization(Organization organization) {
        Organization organizationResult = organizationRepository.save(organization);
        if (organizationResult == null) {
            log.error("Could not save organization!");
            throw new AuthDomainException("Could not save organization!");
        }
        log.info("Organization is saved with id: {}", organizationResult.getId().getValue());
        return organizationResult;
    }
}
