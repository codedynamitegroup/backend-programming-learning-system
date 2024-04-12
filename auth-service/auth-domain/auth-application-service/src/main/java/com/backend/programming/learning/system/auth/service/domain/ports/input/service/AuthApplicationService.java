package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.create.*;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;
import javax.validation.Valid;

public interface AuthApplicationService {
    CreateUserResponse createUser(@Valid CreateUserCommand createUserCommand);
    CreateRoleResponse createRole(@Valid CreateRoleCommand createRoleCommand);
    CreateOrganizationResponse createOrganization(@Valid CreateOrganizationCommand createOrganizationCommand);
    QueryUserResponse findUserById(QueryUserCommand queryUserCommand);
}
