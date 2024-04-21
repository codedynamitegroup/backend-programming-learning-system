package com.backend.programming.learning.system.ports.input.service.organization;

import com.backend.programming.learning.system.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.dto.method.create.organization.CreateOrganizationResponse;
import com.backend.programming.learning.system.dto.method.delete.organization.DeleteOrganizationCommand;
import com.backend.programming.learning.system.dto.method.delete.organization.DeleteOrganizationResponse;
import com.backend.programming.learning.system.dto.method.query.organization.QueryAllOrganizationResponse;
import com.backend.programming.learning.system.dto.method.query.organization.QueryOrganizationCommand;
import com.backend.programming.learning.system.dto.method.update.organization.UpdateOrganizationCommand;
import com.backend.programming.learning.system.dto.method.update.organization.UpdateOrganizationResponse;
import com.backend.programming.learning.system.dto.responseentity.organization.OrganizationResponseEntity;

import javax.validation.Valid;

public interface OrganizationApplicationService {

    CreateOrganizationResponse createOrganization(@Valid CreateOrganizationCommand createOrganizationCommand);

    OrganizationResponseEntity queryOrganizationById(@Valid QueryOrganizationCommand queryOrganizationCommand);

    QueryAllOrganizationResponse queryAllOrganization();

    DeleteOrganizationResponse deleteOrganization(@Valid DeleteOrganizationCommand deleteOrganizationCommand);

    UpdateOrganizationResponse updateOrganization(@Valid UpdateOrganizationCommand updateOrganizationCommand);
}
