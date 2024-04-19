package com.backend.programming.learning.system.auth.service.domain.implement.organization;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.organization.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.organization.DeleteOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.organization.DeleteOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryAllOrganizationsCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryAllOrganizationsResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryOrganizationByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.organization.UpdateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.organization.UpdateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.organization.OrganizationEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.mapper.OrganizationDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class OrganizationCommandHandler {

    private final OrganizationCreateHelper organizationCreateHelper;
    private final OrganizationDeleteHelper organizationDeleteHelper;
    private final OrganizationQueryHelper organizationQueryHelper;
    private final OrganizationUpdateHelper organizationUpdateHelper;
    private final OrganizationDataMapper organizationDataMapper;

    public OrganizationCommandHandler(OrganizationCreateHelper organizationCreateHelper, OrganizationDataMapper organizationDataMapper, OrganizationQueryHelper organizationQueryHelper, OrganizationDeleteHelper organizationDeleteHelper, OrganizationUpdateHelper organizationUpdateHelper) {
        this.organizationCreateHelper = organizationCreateHelper;
        this.organizationDataMapper = organizationDataMapper;
        this.organizationQueryHelper = organizationQueryHelper;
        this.organizationDeleteHelper = organizationDeleteHelper;
        this.organizationUpdateHelper = organizationUpdateHelper;
    }

    @Transactional
    public CreateOrganizationResponse createOrganization(CreateOrganizationCommand createOrganizationCommand) {
        Organization organizationCreated = organizationCreateHelper.persistOrganization(createOrganizationCommand);
        log.info("Organization is created with id: {}", organizationCreated.getId().getValue());
        return organizationDataMapper.organizationToCreateOrganizationResponse(organizationCreated,
                "Organization created successfully");
    }

    @Transactional(readOnly = true)
    public OrganizationEntityResponse queryOrganizationById(QueryOrganizationByIdCommand queryOrganizationCommand) {
        Organization organization = organizationQueryHelper.queryOrganization(queryOrganizationCommand.getOrganizationId());
        log.info("Organization is queried with id: {}", queryOrganizationCommand.getOrganizationId());
        return organizationDataMapper.organizationToOrganizationEntityResponse(organization);
    }

    @Transactional(readOnly = true)
    public QueryAllOrganizationsResponse queryAllOrganizations(QueryAllOrganizationsCommand queryAllOrganizationsCommand) {
        Page<Organization> organizations = organizationQueryHelper.queryAllOrganizations(queryAllOrganizationsCommand.getPageNo(), queryAllOrganizationsCommand.getPageSize());
        log.info("All organizations are queried");
        return organizationDataMapper.organizationsToQueryAllOrganizationsResponse(organizations);
    }

    @Transactional
    public UpdateOrganizationResponse updateOrganization(UpdateOrganizationCommand updateOrganizationCommand) {
        Organization organizationUpdated = organizationUpdateHelper.persistOrganization(updateOrganizationCommand);
        log.info("Organization is updated with id: {}", organizationUpdated.getId().getValue());
        return UpdateOrganizationResponse.builder()
                .organizationId(organizationUpdated.getId().getValue())
                .message("Organization updated successfully")
                .build();
    }

    @Transactional
    public DeleteOrganizationResponse deleteOrganization(DeleteOrganizationCommand deleteOrganizationCommand) {
        organizationDeleteHelper.deleteOrganization(deleteOrganizationCommand);
        log.info("Organization is deleted with id: {}", deleteOrganizationCommand.getOrganizationId());
        return DeleteOrganizationResponse.builder()
                .organizationId(deleteOrganizationCommand.getOrganizationId())
                .message("Organization deleted successfully")
                .build();
    }

}
