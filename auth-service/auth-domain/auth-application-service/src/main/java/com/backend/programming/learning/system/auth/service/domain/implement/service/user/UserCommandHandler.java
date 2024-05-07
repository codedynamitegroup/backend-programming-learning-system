package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryAllUsersCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryUserByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryAllUsersResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.user.UserUpdateSagaHelper;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user.UserOutboxHelper;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserCommandHandler {

    private final UserCreateHelper userCreateHelper;
    private final UserDeleteHelper userDeleteHelper;
    private final UserDataMapper userDataMapper;
    private final UserQueryHelper userQueryHelper;
    private final UserUpdateHelper userUpdateHelper;
    private final UserOutboxHelper userOutboxHelper;
    private final UserUpdateSagaHelper userSagaHelper;
    private final UserLoginHelper userLoginHelper;
    private final UserRefreshTokenHelper userRefreshTokenHelper;

    @Transactional
    public CreateUserResponse createUser(CreateUserCommand createOrderCommand) {
        UserCreatedEvent userCreatedEvent = userCreateHelper.persistUser(createOrderCommand);
        log.info("User is created with id: {}", userCreatedEvent.getUser().getId().getValue());
        CreateUserResponse createUserResponse = userDataMapper.userToCreateUserResponse(userCreatedEvent.getUser(),
                "User created successfully");

        userOutboxHelper.saveUserOutboxMessage(
                userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                ServiceName.CORE_SERVICE,
                CopyState.CREATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                ServiceName.COURSE_SERVICE,
                CopyState.CREATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                ServiceName.CODE_ASSESSMENT_SERVICE,
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
                ServiceName.CORE_SERVICE,
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                ServiceName.COURSE_SERVICE,
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                ServiceName.CODE_ASSESSMENT_SERVICE,
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
                ServiceName.CORE_SERVICE,
                CopyState.DELETING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.DELETING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                userDataMapper.userDeletedEventToUserEventPayload(userDeletedEvent),
                ServiceName.COURSE_SERVICE,
                CopyState.DELETING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.DELETING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                userDataMapper.userDeletedEventToUserEventPayload(userDeletedEvent),
                ServiceName.CODE_ASSESSMENT_SERVICE,
                CopyState.DELETING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.DELETING),
                UUID.randomUUID());

        return userDataMapper.deleteUserResponse(deleteUserCommand.getUserId(),
                "User deleted successfully");
    }

    public LoginUserResponse loginUser(LoginUserCommand loginUserCommand) {
        return userLoginHelper.loginUser(loginUserCommand);
    }

    public RefreshTokenUserResponse refreshTokenUser(RefreshTokenUserCommand refreshTokenUserCommand) {
        return userRefreshTokenHelper.refreshTokenUser(refreshTokenUserCommand);
    }
}
