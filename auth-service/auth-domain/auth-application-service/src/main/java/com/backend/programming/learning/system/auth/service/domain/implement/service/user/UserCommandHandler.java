package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryAllUsersCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryUserByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryAllUsersResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.user.UserUpdateSagaHelper;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user.UserOutboxHelper;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
public class UserCommandHandler {

    private final UserCreateHelper userCreateHelper;
    private final UserDeleteHelper userDeleteHelper;
    private final UserDataMapper userDataMapper;
    private final UserQueryHelper userQueryHelper;
    private final UserUpdateHelper userUpdateHelper;
    private final UserOutboxHelper userOutboxHelper;
    private final UserUpdateSagaHelper userSagaHelper;

    public UserCommandHandler(UserCreateHelper userCreateHelper, UserDeleteHelper userDeleteHelper, UserDataMapper userDataMapper, UserQueryHelper userQueryHelper, UserUpdateHelper userUpdateHelper, UserOutboxHelper userOutboxHelper, UserUpdateSagaHelper userSagaHelper) {
        this.userCreateHelper = userCreateHelper;
        this.userDeleteHelper = userDeleteHelper;
        this.userDataMapper = userDataMapper;
        this.userQueryHelper = userQueryHelper;
        this.userUpdateHelper = userUpdateHelper;
        this.userOutboxHelper = userOutboxHelper;
        this.userSagaHelper = userSagaHelper;
    }

    @Transactional
    public CreateUserResponse createUser(CreateUserCommand createOrderCommand) {
        UserCreatedEvent userCreatedEvent = userCreateHelper.persistUser(createOrderCommand);
        log.info("User is created with id: {}", userCreatedEvent.getUser().getId().getValue());
        CreateUserResponse createUserResponse = userDataMapper.userToCreateUserResponse(userCreatedEvent.getUser(),
                "User created successfully");

        userOutboxHelper.saveUserOutboxMessage(
                        userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                        CopyState.CREATING,
                        OutboxStatus.STARTED,
                        userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                                UUID.randomUUID());

        return createUserResponse;
    }

    @Transactional(readOnly = true)
    public UserEntityResponse queryUser(QueryUserByIdCommand queryUserCommand) {
        User user = userQueryHelper.queryUser(queryUserCommand.getUserId());
        log.info("Role is queried with id: {}", queryUserCommand.getUserId());
        return userDataMapper.userToUserResponse(user);
    }

    @Transactional(readOnly = true)
    public QueryAllUsersResponse queryAllUsers(QueryAllUsersCommand queryAllUsersCommand) {
        Page<User> users = userQueryHelper.queryAllUsers(queryAllUsersCommand.getPageNo(), queryAllUsersCommand.getPageSize());
        log.info("All users are queried");
        return userDataMapper.usersToQueryAllUsers(users);
    }

    @Transactional
    public UpdateUserResponse updateUser(UpdateUserCommand updateUserCommand) {
        UserUpdatedEvent userUpdatedEvent = userUpdateHelper.persistUser(updateUserCommand);

        userOutboxHelper.saveUserOutboxMessage(
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        log.info("User is updated with id: {}", userUpdatedEvent.getUser().getId().getValue());
        return userDataMapper.userToUpdateUserResponse(userUpdatedEvent.getUser(), "User updated successfully");
    }


    @Transactional
    public DeleteUserResponse deleteUser(DeleteUserCommand deleteUserCommand) {
        UserDeletedEvent userDeletedEvent = userDeleteHelper.deleteUser(deleteUserCommand);
        log.info("User is deleted with id: {}", deleteUserCommand.getUserId());

        userOutboxHelper.saveUserOutboxMessage(
                userDataMapper.userDeletedEventToUserEventPayload(userDeletedEvent),
                CopyState.DELETING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.DELETING),
                UUID.randomUUID());
        return userDataMapper.deleteUserResponse(deleteUserCommand.getUserId(),
                "User deleted successfully");
    }
}
