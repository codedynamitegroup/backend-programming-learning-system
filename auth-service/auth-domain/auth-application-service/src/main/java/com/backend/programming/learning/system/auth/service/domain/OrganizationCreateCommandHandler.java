package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.mapper.OrganizationDataMapper;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrganizationCreateCommandHandler {

    private final OrganizationCreateHelper organizationCreateHelper;

    private final OrganizationDataMapper organizationDataMapper;

    public OrganizationCreateCommandHandler(OrganizationCreateHelper organizationCreateHelper, OrganizationDataMapper organizationDataMapper) {
        this.organizationCreateHelper = organizationCreateHelper;
        this.organizationDataMapper = organizationDataMapper;
    }

    public CreateOrganizationResponse createOrganization(CreateOrganizationCommand createOrganizationCommand) {
        Organization organizationCreated = organizationCreateHelper.persistOrganization(createOrganizationCommand);
        log.info("Organization is created with id: {}", organizationCreated.getId().getValue());
        return organizationDataMapper.OrganizationToCreateOrganizationResponse(organizationCreated,
                "Organization created successfully");
    }

}
