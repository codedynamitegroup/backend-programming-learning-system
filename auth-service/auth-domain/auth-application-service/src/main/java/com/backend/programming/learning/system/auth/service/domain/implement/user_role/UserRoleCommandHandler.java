package com.backend.programming.learning.system.auth.service.domain.implement.user_role;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role.DeleteUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role.DeleteUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user_role.QueryUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user_role.UpdateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user_role.UpdateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_role.UserRoleEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserRoleDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class UserRoleCommandHandler {

    private final UserRoleCreateHelper userRoleCreateHelper;
    private final UserRoleDeleteHelper userRoleDeleteHelper;
    private final UserRoleDataMapper userRoleDataMapper;
    private final UserRoleQueryHelper userRoleQueryHelper;
    private final UserRoleUpdateHelper userRoleUpdateHelper;

    public UserRoleCommandHandler(UserRoleCreateHelper userRoleCreateHelper, UserRoleDeleteHelper userRoleDeleteHelper, UserRoleDataMapper userRoleDataMapper, UserRoleQueryHelper userRoleQueryHelper, UserRoleUpdateHelper userRoleUpdateHelper) {
        this.userRoleCreateHelper = userRoleCreateHelper;
        this.userRoleDeleteHelper = userRoleDeleteHelper;
        this.userRoleDataMapper = userRoleDataMapper;
        this.userRoleQueryHelper = userRoleQueryHelper;
        this.userRoleUpdateHelper = userRoleUpdateHelper;
    }

    @Transactional
    public CreateUserRoleResponse createUserRole(CreateUserRoleCommand createUserRoleCommand) {
        UserRole userRoleCreated = userRoleCreateHelper.persistUserRole(createUserRoleCommand);
        log.info("User role is created with id: {}", userRoleCreated.getId().getValue());
        return userRoleDataMapper.userRoleToCreateUserRoleResponse(userRoleCreated,
                "User role created successfully");
    }

    @Transactional(readOnly = true)
    public UserRoleEntityResponse queryUserRole(QueryUserRoleCommand queryUserRoleCommand) {
        UserRole userRole = userRoleQueryHelper.queryUserRole(queryUserRoleCommand.getRoleId(), queryUserRoleCommand.getUserId());
        log.info("User role is queried with role id: {} and user id: {}",
                queryUserRoleCommand.getRoleId(), queryUserRoleCommand.getUserId());
        return userRoleDataMapper.userRoleToUserRoleResponse(userRole);
    }

    @Transactional
    public UpdateUserRoleResponse updateUserRole(UpdateUserRoleCommand updateUserRoleCommand) {
        UserRole userRoleUpdated = userRoleUpdateHelper.persistUserRole(updateUserRoleCommand);
        log.info("User role is updated with id: {}", userRoleUpdated.getId().getValue());
        return userRoleDataMapper.userRoleToUpdateUserRoleResponse(userRoleUpdated,
                "User role updated successfully");
    }

    @Transactional
    public DeleteUserRoleResponse deleteUserRole(DeleteUserRoleCommand deleteUserRoleCommand) {
        userRoleDeleteHelper.deleteUserRole(deleteUserRoleCommand);
        log.info("User role is deleted with role id: {} and user id: {}",
                deleteUserRoleCommand.getRoleId(), deleteUserRoleCommand.getUserId());
        return userRoleDataMapper.deleteUserRoleResponse(deleteUserRoleCommand.getRoleId(), deleteUserRoleCommand.getUserId(),
                "User role deleted successfully");
    }
}
