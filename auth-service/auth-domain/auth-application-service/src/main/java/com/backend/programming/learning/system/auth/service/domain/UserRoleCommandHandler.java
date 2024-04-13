package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserRoleDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRoleRepository;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class UserRoleCommandHandler {

    private final UserRoleCreateHelper userRoleCreateHelper;
    private final UserRoleDeleteHelper userRoleDeleteHelper;
    private final UserRoleDataMapper userRoleDataMapper;
    private final UserRoleRepository userRoleRepository;

    public UserRoleCommandHandler(UserRoleCreateHelper userRoleCreateHelper, UserRoleDeleteHelper userRoleDeleteHelper, UserRoleDataMapper userRoleDataMapper, UserRoleRepository userRoleRepository) {
        this.userRoleCreateHelper = userRoleCreateHelper;
        this.userRoleDeleteHelper = userRoleDeleteHelper;
        this.userRoleDataMapper = userRoleDataMapper;
        this.userRoleRepository = userRoleRepository;
    }

    public CreateUserRoleResponse createUserRole(CreateUserRoleCommand createUserRoleCommand) {
        UserRole userRoleCreated = userRoleCreateHelper.persistUserRole(createUserRoleCommand);
        log.info("User role is created with id: {}", userRoleCreated.getId().getValue());
        return userRoleDataMapper.userRoleToCreateUserRoleResponse(userRoleCreated,
                "User role created successfully");
    }

    @Transactional(readOnly = true)
    public QueryUserRoleResponse queryUserRole(QueryUserRoleCommand queryUserRoleCommand) {
        Optional<UserRole> userRoleResult =
                userRoleRepository.findByRoleIdAndUserId(new RoleId(queryUserRoleCommand.getRoleId()), new UserId(queryUserRoleCommand.getUserId()));
        if (userRoleResult.isEmpty()) {
            log.warn("Could not find user role with role id: {} and user id: {}",
                    queryUserRoleCommand.getRoleId(), queryUserRoleCommand.getUserId());
            throw new AuthNotFoundException("Could not find user role with role id: " + queryUserRoleCommand.getRoleId() +
                    " and user id: " + queryUserRoleCommand.getUserId());
        }
        return  userRoleDataMapper.userRoleToQueryUserRoleResponse(userRoleResult.get());
    }

    public DeleteUserRoleResponse deleteUserRole(DeleteUserRoleCommand deleteUserRoleCommand) {
        userRoleDeleteHelper.deleteUserRole(deleteUserRoleCommand);
        log.info("User role is deleted with role id: {} and user id: {}",
                deleteUserRoleCommand.getRoleId(), deleteUserRoleCommand.getUserId());
        return DeleteUserRoleResponse.builder()
                .message("User role deleted successfully")
                .build();
    }
}
