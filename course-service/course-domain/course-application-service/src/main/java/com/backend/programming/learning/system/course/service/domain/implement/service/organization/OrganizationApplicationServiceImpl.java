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
import com.backend.programming.learning.system.course.service.domain.ports.input.service.organization.OrganizationApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class OrganizationApplicationServiceImpl implements OrganizationApplicationService {

    private final OrganizationCommandHandler organizationCommandHandler;
    @Override
    public CreateOrganizationResponse createOrganization(CreateOrganizationCommand createOrganizationCommand) {
        return organizationCommandHandler.createOrganization(createOrganizationCommand);
    }

    @Override
    public OrganizationResponseEntity queryOrganizationById(QueryOrganizationCommand queryOrganizationCommand) {
        return organizationCommandHandler.queryOrganizationById(queryOrganizationCommand);
    }

    @Override
    public QueryAllOrganizationResponse queryAllOrganization() {
        return organizationCommandHandler.queryAllOrganization();
    }

    @Override
    public DeleteOrganizationResponse deleteOrganization(DeleteOrganizationCommand deleteOrganizationCommand) {
        return organizationCommandHandler.deleteOrganizationById(deleteOrganizationCommand);
    }

    @Override
    public UpdateOrganizationResponse updateOrganization(UpdateOrganizationCommand updateOrganizationCommand) {
        return organizationCommandHandler.updateOrganization(updateOrganizationCommand);
    }
}
