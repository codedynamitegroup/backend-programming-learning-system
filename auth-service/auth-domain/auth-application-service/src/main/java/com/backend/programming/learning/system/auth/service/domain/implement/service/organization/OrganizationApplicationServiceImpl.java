package com.backend.programming.learning.system.auth.service.domain.implement.service.organization;

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
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.OrganizationApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class OrganizationApplicationServiceImpl implements OrganizationApplicationService {
    private final OrganizationCommandHandler organizationCommandHandler;

    OrganizationApplicationServiceImpl(OrganizationCommandHandler organizationCommandHandler) {
        this.organizationCommandHandler = organizationCommandHandler;
    }


    @Override
    public CreateOrganizationResponse createOrganization(CreateOrganizationCommand createOrganizationCommand) {
        return organizationCommandHandler.createOrganization(createOrganizationCommand);
    }

    @Override
    public OrganizationEntityResponse findOrganizationById(QueryOrganizationByIdCommand queryOrganizationCommand) {
        return organizationCommandHandler.queryOrganizationById(queryOrganizationCommand);
    }

    @Override
    public QueryAllOrganizationsResponse findAllOrganizations(QueryAllOrganizationsCommand queryAllOrganizationsCommand) {
        return organizationCommandHandler.queryAllOrganizations(queryAllOrganizationsCommand);
    }

    @Override
    public UpdateOrganizationResponse updateOrganization(UpdateOrganizationCommand updateOrganizationCommand) {
        return organizationCommandHandler.updateOrganization(updateOrganizationCommand);
    }

    @Override
    public DeleteOrganizationResponse deleteOrganizationById(DeleteOrganizationCommand deleteOrganizationCommand) {
        return organizationCommandHandler.deleteOrganization(deleteOrganizationCommand);
    }
}
