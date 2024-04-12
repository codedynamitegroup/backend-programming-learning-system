package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.*;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationResponse;
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
    public QueryOrganizationResponse findOrganizationById(QueryOrganizationCommand queryOrganizationCommand) {
        return organizationCommandHandler.queryOrganization(queryOrganizationCommand);
    }
}
