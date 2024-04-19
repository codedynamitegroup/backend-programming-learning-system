package com.backend.programming.learning.system.auth.service.domain.implement.organization;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.organization.DeleteOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.organization.DeleteOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryAllOrganizationsCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryAllOrganizationsResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryOrganizationByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.organization.OrganizationEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.OrganizationApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

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
    public DeleteOrganizationResponse deleteOrganizationById(DeleteOrganizationCommand deleteOrganizationCommand) {
        return organizationCommandHandler.deleteOrganization(deleteOrganizationCommand);
    }
}
