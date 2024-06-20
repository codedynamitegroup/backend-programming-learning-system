package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.dto.method.assign_user_to_organization.AssignUserToOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.assign_user_to_organization.AssignUserToOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.assign_user_to_organization.UnassignedUserToOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.assign_user_to_organization.UnassignedUserToOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.change_password.ChangedPasswordUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.change_password.ChangedPasswordUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.RegisterUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.forgot_password.*;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.SocialLoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.logout.LogoutUserEmailCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.logout.LogoutUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.*;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserEmailCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserByAdminCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserProfileCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.auth_to_any_services.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.auth_to_any_services.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.auth_to_any_services.UserUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.user.UserUpdateSagaHelper;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user.UserOutboxHelper;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.backend.programming.learning.system.saga.user.SagaConstants.AUTH_TO_ANY_SERVICES_USER_SAGA_NAME;

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
    private final UserSocialLoginHelper userSocialLoginHelper;
    private final UserLogoutHelper userLogoutHelper;
    private final UserChangedPasswordHelper userChangedPasswordHelper;
    private final UserForgotPasswordHelper userForgotPasswordHelper;

    @Transactional
    public CreateUserResponse createUserByAdmin(CreateUserCommand createOrderCommand) {
        UserCreatedEvent userCreatedEvent = userCreateHelper.createUser(createOrderCommand);
        log.info("User is created with id: {}", userCreatedEvent.getUser().getId().getValue());
        CreateUserResponse createUserResponse = userDataMapper.userToCreateUserResponse(userCreatedEvent.getUser(),
                "User created successfully");

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                ServiceName.CORE_SERVICE,
                CopyState.CREATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                ServiceName.COURSE_SERVICE,
                CopyState.CREATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                ServiceName.CODE_ASSESSMENT_SERVICE,
                CopyState.CREATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                UUID.randomUUID());

        return createUserResponse;
    }

    @Transactional
    public CreateUserResponse registerUser(RegisterUserCommand registerUserCommand) {
        UserCreatedEvent userCreatedEvent = userCreateHelper.registerUser(registerUserCommand);
        log.info("User is created with id: {}", userCreatedEvent.getUser().getId().getValue());
        CreateUserResponse createUserResponse = userDataMapper.userToCreateUserResponse(userCreatedEvent.getUser(),
                "User created successfully");

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                ServiceName.CORE_SERVICE,
                CopyState.CREATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                ServiceName.COURSE_SERVICE,
                CopyState.CREATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
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
        log.info("User is queried with id: {}", queryUserCommand.getUserId());
        return userDataMapper.userToUserResponse(user);
    }

    @Transactional(readOnly = true)
    public UserEntityResponse queryUserByEmail(QueryUserByEmailCommand queryUserByEmailCommand) {
        User user = userQueryHelper.queryUserByEmail(queryUserByEmailCommand.getEmail());
        log.info("User is queried with email: {}", queryUserByEmailCommand.getEmail());
        return userDataMapper.userToUserResponse(user);
    }

    @Transactional(readOnly = true)
    public UserEntityResponse queryUserByEmailAndIsDeletedTrueOrFalse(QueryUserByEmailCommand queryUserByEmailCommand) {
        User user = userQueryHelper.queryUserByEmailAndIsDeletedTrueOrFalse(queryUserByEmailCommand.getEmail());
        log.info("User is queried with email: {}", queryUserByEmailCommand.getEmail());
        return userDataMapper.userToUserResponse(user);
    }

    public UserEntityResponse queryUserByIdAndIsDeletedTrueOrFalse(QueryUserByIdCommand queryUserCommand) {
        User user = userQueryHelper.queryUserByIdAndIsDeletedTrueOrFalse(queryUserCommand.getUserId());
        log.info("User is queried with id: {}", queryUserCommand.getUserId());
        return userDataMapper.userToUserResponse(user);
    }


    @Transactional(readOnly = true)
    public QueryAllUsersResponse queryAllUsers(QueryAllUsersCommand queryAllUsersCommand) {
        Page<User> users = userQueryHelper.queryAllUsers(queryAllUsersCommand.getPageNo(), queryAllUsersCommand.getPageSize(), queryAllUsersCommand.getSearchName());
        log.info("All users are queried");
        return userDataMapper.usersToQueryAllUsers(users);
    }

    @Transactional(readOnly = true)
    public QueryAllUsersResponse queryAllUsersByOrganization(QueryAllUsersByOrganizationCommand queryAllUsersByOrganizationCommand) {
        Page<User> users = userQueryHelper.queryAllUsersByOrganization(
                queryAllUsersByOrganizationCommand.getOrganizationId(),
                queryAllUsersByOrganizationCommand.getPageNo(),
                queryAllUsersByOrganizationCommand.getPageSize(),
                queryAllUsersByOrganizationCommand.getSearchName());
        log.info("All users by organizationId {} are queried", queryAllUsersByOrganizationCommand.getOrganizationId());
        return userDataMapper.usersToQueryAllUsers(users);
    }

    @Transactional
    public UpdateUserResponse updateUserProfile(UpdateUserProfileCommand updateUserCommand) {
        UserUpdatedEvent userUpdatedEvent = userUpdateHelper.updateUserProfile(updateUserCommand);

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                ServiceName.CORE_SERVICE,
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                ServiceName.COURSE_SERVICE,
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
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
    public UpdateUserResponse updateUserByAdmin(UpdateUserByAdminCommand updateUserByAdminCommand) {
        UserUpdatedEvent userUpdatedEvent = userUpdateHelper.updateUserByAdmin(updateUserByAdminCommand);

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                ServiceName.CORE_SERVICE,
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                ServiceName.COURSE_SERVICE,
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
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
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userDeletedEventToUserEventPayload(userDeletedEvent),
                ServiceName.CORE_SERVICE,
                CopyState.DELETING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.DELETING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userDeletedEventToUserEventPayload(userDeletedEvent),
                ServiceName.COURSE_SERVICE,
                CopyState.DELETING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.DELETING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userDeletedEventToUserEventPayload(userDeletedEvent),
                ServiceName.CODE_ASSESSMENT_SERVICE,
                CopyState.DELETING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.DELETING),
                UUID.randomUUID());

        return userDataMapper.deleteUserResponse(deleteUserCommand.getUserId(),
                "User deleted successfully");
    }

    @Transactional
    public LoginUserResponse loginUser(LoginUserCommand loginUserCommand) {
        return userLoginHelper.loginUser(loginUserCommand);
    }

    @Transactional
    public RefreshTokenUserResponse refreshTokenUser(RefreshTokenUserEmailCommand refreshTokenUserCommand) {
        return userRefreshTokenHelper.refreshTokenUser(refreshTokenUserCommand);
    }

    @Transactional
    public LoginUserResponse socialLoginUser(SocialLoginUserCommand socialLoginUserCommand) {
        return userSocialLoginHelper.socialLoginUser(socialLoginUserCommand);
    }

    public LogoutUserResponse logoutUser(LogoutUserEmailCommand logoutUserEmailCommand) {
        return userLogoutHelper.logoutUser(logoutUserEmailCommand);
    }

    public ChangedPasswordUserResponse changePasswordUser(ChangedPasswordUserCommand changedPasswordUserCommand) {
        return userChangedPasswordHelper.changedPasswordUser(changedPasswordUserCommand);
    }

    public ForgotPasswordEmailResponse forgotPasswordEmail(ForgotPasswordEmailCommand forgotPasswordEmailCommand) throws MessagingException {
        return userForgotPasswordHelper.forgotPasswordUser(forgotPasswordEmailCommand);
    }

    public VerifyOTPResponse verifyOTP(VerifyOTPCommand verifyOTPCommand) {
        return userForgotPasswordHelper.verifyOTP(verifyOTPCommand);
    }

    public ResetPasswordResponse forgotPasswordChangePassword(
            ResetPasswordCommand forgotPasswordChangePasswordCommand) {
        return userForgotPasswordHelper.changedPasswordUser(forgotPasswordChangePasswordCommand);
    }

    public QueryGeneralStatisticUserResponse getStatisticUser() {
        return userQueryHelper.getStatisticUser();
    }

    public AssignUserToOrganizationResponse assignUserToOrganization(AssignUserToOrganizationCommand assignUserToOrganizationCommand) {
        UserUpdatedEvent userUpdatedEvent = userUpdateHelper.assignUserToOrganization(assignUserToOrganizationCommand);

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                ServiceName.CORE_SERVICE,
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                ServiceName.COURSE_SERVICE,
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                ServiceName.CODE_ASSESSMENT_SERVICE,
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        log.info("User is updated with id: {}", userUpdatedEvent.getUser().getId().getValue());
        return AssignUserToOrganizationResponse.builder()
                .message("User is assigned to organization successfully")
                .userId(userUpdatedEvent.getUser().getId().getValue())
                .build();
    }

    public UnassignedUserToOrganizationResponse unassignedUserToOrganization(UnassignedUserToOrganizationCommand unassignedUserToOrganizationCommand) {
        UserUpdatedEvent userUpdatedEvent = userUpdateHelper.unassignedUserToOrganization(unassignedUserToOrganizationCommand);

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                ServiceName.CORE_SERVICE,
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                ServiceName.COURSE_SERVICE,
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        userOutboxHelper.saveUserOutboxMessage(
                AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                userDataMapper.userUpdatedEventToUserEventPayload(userUpdatedEvent),
                ServiceName.CODE_ASSESSMENT_SERVICE,
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                userSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());

        log.info("User is updated with id: {}", userUpdatedEvent.getUser().getId().getValue());
        return UnassignedUserToOrganizationResponse.builder()
                .message("User is unassigned to organization successfully")
                .userId(userUpdatedEvent.getUser().getId().getValue())
                .build();
    }
}
