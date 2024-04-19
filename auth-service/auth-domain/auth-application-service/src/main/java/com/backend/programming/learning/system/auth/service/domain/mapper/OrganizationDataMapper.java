package com.backend.programming.learning.system.auth.service.domain.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.organization.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryAllOrganizationsResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.organization.UpdateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.organization.UpdateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.organization.OrganizationEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizationDataMapper {
    private final UserDataMapper userDataMapper;

    public OrganizationDataMapper(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }

    public Organization createOrganizationCommandToOrganization(CreateOrganizationCommand createOrganizationCommand) {
        return Organization.builder()
                .email(createOrganizationCommand.getEmail())
                .description(createOrganizationCommand.getDescription())
                .name(createOrganizationCommand.getName())
                .phone(createOrganizationCommand.getPhone())
                .address(createOrganizationCommand.getAddress())
                .createdBy(User
                        .builder()
                        .id(new UserId(createOrganizationCommand.getCreatedBy()))
                        .build())
                .updatedBy(User
                        .builder()
                        .id(new UserId(createOrganizationCommand.getUpdatedBy()))
                        .build())
                .build();
    }

    public CreateOrganizationResponse organizationToCreateOrganizationResponse(Organization organization, String message) {
        return CreateOrganizationResponse.builder()
                .id(organization.getId().getValue())
                .email(organization.getEmail())
                .name(organization.getName())
                .message(message)
                .build();
    }

    public OrganizationEntityResponse organizationToOrganizationEntityResponse(Organization organization) {
        UserEntityResponse createdBy = userDataMapper.userToUserResponse(organization.getCreatedBy());
        UserEntityResponse updatedBy = userDataMapper.userToUserResponse(organization.getUpdatedBy());

        return OrganizationEntityResponse.builder()
                .organizationId(organization.getId().getValue())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .email(organization.getEmail())
                .description(organization.getDescription())
                .name(organization.getName())
                .phone(organization.getPhone())
                .address(organization.getAddress())
                .apiKey(organization.getApiKey())
                .moodleUrl(organization.getMoodleUrl())
                .createdAt(organization.getCreatedAt())
                .updatedAt(organization.getUpdatedAt())
                .isDeleted(organization.getDeleted())
                .build();
    }

    public QueryAllOrganizationsResponse organizationsToQueryAllOrganizationsResponse(Page<Organization> organizations) {
        List<OrganizationEntityResponse> organizationEntityResponses = organizations
                .map(this::organizationToOrganizationEntityResponse).getContent();
        return QueryAllOrganizationsResponse.builder()
                .organizations(organizationEntityResponses)
                .currentPage(organizations.getNumber())
                .totalPages(organizations.getTotalPages())
                .totalItems(organizations.getTotalElements())
                .build();
    }


}
