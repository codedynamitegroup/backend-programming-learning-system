package com.backend.programming.learning.system.auth.service.domain.implement.user_role;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserRoleResponse;
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
    public CreateUserRoleResponse createUserRole(CreateUserRoleCommand createUserRoleCommand) {
        return userRoleCommandHandler.createUserRole(createUserRoleCommand);
    }

    @Override
    public QueryUserRoleResponse findUserRoleByRoleIdAndUserId(QueryUserRoleCommand queryOrganizationCommand) {
        return userRoleCommandHandler.queryUserRole(queryOrganizationCommand);
    }

    @Override
    public DeleteUserRoleResponse deleteUserRoleByRoleIdAndUserId(DeleteUserRoleCommand deleteUserRoleCommand) {
        return userRoleCommandHandler.deleteUserRole(deleteUserRoleCommand);
    }
}
