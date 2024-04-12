package com.backend.programming.learning.system.auth.service.domain.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationDataMapper {
    public Organization createOrganizationCommandToOrganization(CreateOrganizationCommand createOrganizationCommand) {
        return Organization.builder()
                .email(createOrganizationCommand.getEmail())
                .description(createOrganizationCommand.getDescription())
                .name(createOrganizationCommand.getName())
                .phone(createOrganizationCommand.getPhone())
                .address(createOrganizationCommand.getAddress())
                .build();
    }

    public CreateOrganizationResponse OrganizationToCreateOrganizationResponse(Organization organization, String message) {
        return CreateOrganizationResponse.builder()
                .email(organization.getEmail())
                .description(organization.getDescription())
                .name(organization.getName())
                .phone(organization.getPhone())
                .address(organization.getAddress())
                .message(message)
                .build();
    }
}
