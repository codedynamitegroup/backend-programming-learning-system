package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserRoleResponse;

import javax.validation.Valid;

public interface UserRoleApplicationService {
    CreateUserRoleResponse createUserRole(@Valid CreateUserRoleCommand createUserRoleCommand);
    QueryUserRoleResponse findUserRoleById(@Valid QueryUserRoleCommand queryOrganizationCommand);
    DeleteUserRoleResponse deleteUserRoleById(@Valid DeleteUserRoleCommand deleteUserRoleCommand);
}
