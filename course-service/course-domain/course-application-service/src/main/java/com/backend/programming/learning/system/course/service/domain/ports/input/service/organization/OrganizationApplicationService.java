package com.backend.programming.learning.system.course.service.domain.ports.input.service.organization;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.organization.CreateOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.organization.DeleteOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.organization.DeleteOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.organization.QueryAllOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.organization.QueryOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.SyncOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.UpdateOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.UpdateOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.organization.OrganizationResponseEntity;

import jakarta.validation.Valid;

import java.util.UUID;

public interface OrganizationApplicationService {

    CreateOrganizationResponse createOrganization(@Valid CreateOrganizationCommand createOrganizationCommand);

    OrganizationResponseEntity queryOrganizationById(@Valid QueryOrganizationCommand queryOrganizationCommand);

    QueryAllOrganizationResponse queryAllOrganization();

    DeleteOrganizationResponse deleteOrganization(@Valid DeleteOrganizationCommand deleteOrganizationCommand);

    UpdateOrganizationResponse updateOrganization(UUID organizationId,@Valid UpdateOrganizationCommand updateOrganizationCommand);

}
