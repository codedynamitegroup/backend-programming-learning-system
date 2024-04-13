package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.create.*;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationResponse;
import javax.validation.Valid;

public interface OrganizationApplicationService {
    CreateOrganizationResponse createOrganization(@Valid CreateOrganizationCommand createOrganizationCommand);
    QueryOrganizationResponse findOrganizationById(@Valid QueryOrganizationCommand queryOrganizationCommand);
    DeleteOrganizationResponse deleteOrganizationById(@Valid DeleteOrganizationCommand deleteOrganizationCommand);
}
