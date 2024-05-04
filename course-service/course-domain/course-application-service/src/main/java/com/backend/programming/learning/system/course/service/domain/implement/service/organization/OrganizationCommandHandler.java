package com.backend.programming.learning.system.course.service.domain.implement.service.organization;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.organization.CreateOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.organization.DeleteOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.organization.DeleteOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.organization.QueryAllOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.organization.QueryOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.UpdateOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.UpdateOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.organization.OrganizationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.mapper.organization.OrganizationDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrganizationCommandHandler {
    private final OrganizationCreateHelper organizationCreateHelper;
    private final OrganizationQueryHelper organizationQueryHelper;
    private final OrganizationDeleteHelper organizationDeleteHelper;
    private final OrganizationUpdateHelper organizationUpdateHelper;
    private final OrganizationDataMapper organizationDataMapper;

    @Transactional
    public CreateOrganizationResponse createOrganization(CreateOrganizationCommand createOrganizationCommand) {
        log.info("Create organization command received");
        Organization organization = organizationCreateHelper.persistOrganization(createOrganizationCommand);
        return organizationDataMapper.organizationToCreateOrganizationResponse(organization, "Organization created successfully");
    }

    @Transactional(readOnly = true)
    public OrganizationResponseEntity queryOrganizationById(QueryOrganizationCommand queryOrganizationCommand) {
        log.info("Query organization by id command received");
        Organization organization = organizationQueryHelper.queryOrganizationById(queryOrganizationCommand.getOrganizationId());
        return organizationDataMapper.organizationToOrganizationResponseEntity(organization);
    }

    @Transactional(readOnly = true)
    public QueryAllOrganizationResponse queryAllOrganization() {
        return organizationQueryHelper.queryAllOrganization();
    }

    @Transactional
    public DeleteOrganizationResponse deleteOrganizationById(DeleteOrganizationCommand deleteOrganizationCommand) {
        organizationDeleteHelper.deleteOrganizationById(deleteOrganizationCommand.getOrganizationId());
        return DeleteOrganizationResponse.builder()
                .organizationId(deleteOrganizationCommand.getOrganizationId())
                .message("Organization deleted successfully")
                .build();
    }

    @Transactional
    public UpdateOrganizationResponse updateOrganization(UpdateOrganizationCommand updateOrganizationCommand) {
        organizationUpdateHelper.persistOrganization(updateOrganizationCommand);
        return UpdateOrganizationResponse.builder()
                .organizationId(updateOrganizationCommand.getOrganizationId())
                .message("Organization updated successfully")
                .build();
    }
}
