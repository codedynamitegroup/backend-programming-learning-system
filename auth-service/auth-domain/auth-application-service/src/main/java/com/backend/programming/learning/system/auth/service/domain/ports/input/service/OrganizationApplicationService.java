package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.organization.DeleteOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.organization.DeleteOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryAllOrganizationsCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryAllOrganizationsResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryOrganizationByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.organization.OrganizationEntityResponse;

import javax.validation.Valid;
import java.util.List;

public interface OrganizationApplicationService {
    CreateOrganizationResponse createOrganization(@Valid CreateOrganizationCommand createOrganizationCommand);
    OrganizationEntityResponse findOrganizationById(QueryOrganizationByIdCommand queryOrganizationCommand);
    QueryAllOrganizationsResponse findAllOrganizations(QueryAllOrganizationsCommand queryAllOrganizationsCommand);
    DeleteOrganizationResponse deleteOrganizationById(@Valid DeleteOrganizationCommand deleteOrganizationCommand);
}
