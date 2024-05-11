package com.backend.programming.learning.system.auth.service.domain.implement.service.user_role;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role.DeleteUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role.DeleteUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user_role.QueryUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_role.UserRoleEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserRoleApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class UserRoleApplicationServiceImpl implements UserRoleApplicationService {
    private final UserRoleCommandHandler userRoleCommandHandler;

    UserRoleApplicationServiceImpl(UserRoleCommandHandler userRoleCommandHandler) {
        this.userRoleCommandHandler = userRoleCommandHandler;
    }

    @Override
    public CreateUserRoleResponse createUserRole(CreateUserRoleCommand createUserRoleCommand, String token) {
        return userRoleCommandHandler.createUserRole(createUserRoleCommand, token);
    }

    @Override
    public UserRoleEntityResponse findUserRoleByRoleIdAndUserId(QueryUserRoleCommand queryOrganizationCommand) {
        return userRoleCommandHandler.queryUserRole(queryOrganizationCommand);
    }

    @Override
    public DeleteUserRoleResponse deleteUserRoleByRoleIdAndUserId(DeleteUserRoleCommand deleteUserRoleCommand) {
        return userRoleCommandHandler.deleteUserRole(deleteUserRoleCommand);
    }
}
