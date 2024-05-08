package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

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

import jakarta.validation.Valid;

public interface OrganizationApplicationService {
    CreateOrganizationResponse createOrganization(@Valid CreateOrganizationCommand createOrganizationCommand);
    OrganizationEntityResponse findOrganizationById(QueryOrganizationByIdCommand queryOrganizationCommand);
    QueryAllOrganizationsResponse findAllOrganizations(QueryAllOrganizationsCommand queryAllOrganizationsCommand);
    UpdateOrganizationResponse updateOrganization(@Valid UpdateOrganizationCommand updateOrganizationCommand);
    DeleteOrganizationResponse deleteOrganizationById(@Valid DeleteOrganizationCommand deleteOrganizationCommand);
}
