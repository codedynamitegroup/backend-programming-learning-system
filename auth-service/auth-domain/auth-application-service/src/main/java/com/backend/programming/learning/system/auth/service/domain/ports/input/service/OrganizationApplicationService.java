package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.create.*;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;

import javax.validation.Valid;

public interface OrganizationApplicationService {
    CreateOrganizationResponse createOrganization(@Valid CreateOrganizationCommand createOrganizationCommand);
    QueryOrganizationResponse findOrganizationById(QueryOrganizationCommand queryOrganizationCommand);
}
