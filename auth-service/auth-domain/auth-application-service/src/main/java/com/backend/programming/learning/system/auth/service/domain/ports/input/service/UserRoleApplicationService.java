package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role.DeleteUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role.DeleteUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user_role.QueryUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_role.UserRoleEntityResponse;

import javax.validation.Valid;

public interface UserRoleApplicationService {
    CreateUserRoleResponse createUserRole(@Valid CreateUserRoleCommand createUserRoleCommand);
    UserRoleEntityResponse findUserRoleByRoleIdAndUserId(@Valid QueryUserRoleCommand queryOrganizationCommand);
    DeleteUserRoleResponse deleteUserRoleByRoleIdAndUserId(@Valid DeleteUserRoleCommand deleteUserRoleCommand);
}
