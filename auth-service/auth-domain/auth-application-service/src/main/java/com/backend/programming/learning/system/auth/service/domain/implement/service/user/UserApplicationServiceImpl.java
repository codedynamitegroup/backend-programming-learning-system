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
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserApplicationService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class UserApplicationServiceImpl implements UserApplicationService {
    private final UserCommandHandler userCommandHandler;

    UserApplicationServiceImpl(UserCommandHandler userCommandHandler) {
        this.userCommandHandler = userCommandHandler;
    }

    @Override
    public CreateUserResponse createUserByAdmin(CreateUserCommand createUserCommand) {
        return userCommandHandler.createUserByAdmin(createUserCommand);
    }

    @Override
    public CreateUserResponse registerUser(RegisterUserCommand registerUserCommand) {
        return userCommandHandler.registerUser(registerUserCommand);
    }

    @Override
    public UserEntityResponse findUserById(QueryUserByIdCommand queryUserCommand) {
        return userCommandHandler.queryUser(queryUserCommand);
    }

    @Override
    public AssignUserToOrganizationResponse assignUserToOrganization(AssignUserToOrganizationCommand assignUserToOrganizationCommand) {
        return userCommandHandler.assignUserToOrganization(assignUserToOrganizationCommand);
    }

    @Override
    public UnassignedUserToOrganizationResponse unassignedUserToOrganization(UnassignedUserToOrganizationCommand unassignedUserToOrganizationCommand) {
        return userCommandHandler.unassignedUserToOrganization(unassignedUserToOrganizationCommand);
    }

    @Override
    public UserEntityResponse findUserByIdAndIsDeletedTrueOrFalse(QueryUserByIdCommand queryUserCommand) {
        return userCommandHandler.queryUserByIdAndIsDeletedTrueOrFalse(queryUserCommand);
    }

    @Override
    public UserEntityResponse findUserByEmail(QueryUserByEmailCommand queryUserByEmailCommand) {
        return userCommandHandler.queryUserByEmail(queryUserByEmailCommand);
    }

    @Override
    public UserEntityResponse findUserByEmailAndIsDeletedTrueOrFalse(QueryUserByEmailCommand queryUserByEmailCommand) {
        return userCommandHandler.queryUserByEmailAndIsDeletedTrueOrFalse(queryUserByEmailCommand);
    }


    @Override
    public QueryAllUsersResponse findAllUsers(QueryAllUsersCommand queryAllUsersCommand) {
        return userCommandHandler.queryAllUsers(queryAllUsersCommand);
    }

    @Override
    public QueryAllUsersResponse findAllUsersByOrganization(QueryAllUsersByOrganizationCommand queryAllUsersByOrganizationCommand) {
        return userCommandHandler.queryAllUsersByOrganization(queryAllUsersByOrganizationCommand);
    }

    @Override
    public UpdateUserResponse updateUserByAdmin(UpdateUserByAdminCommand updateUserCommand) {
        return userCommandHandler.updateUserByAdmin(updateUserCommand);
    }

    @Override
    public UpdateUserResponse updateUserProfile(UpdateUserProfileCommand updateUserCommand) {
        return userCommandHandler.updateUserProfile(updateUserCommand);
    }

    @Override
    public DeleteUserResponse deleteUserById(DeleteUserCommand deleteUserCommand) {
        return userCommandHandler.deleteUser(deleteUserCommand);
    }

    @Override
    public LoginUserResponse loginUser(LoginUserCommand loginUserCommand) {
        return userCommandHandler.loginUser(loginUserCommand);
    }

    @Override
    public LoginUserResponse socialLoginUser(SocialLoginUserCommand socialLoginUserCommand) {
        return userCommandHandler.socialLoginUser(socialLoginUserCommand);
    }

    @Override
    public RefreshTokenUserResponse refreshTokenUser(RefreshTokenUserEmailCommand refreshTokenUserCommand) {
        return userCommandHandler.refreshTokenUser(refreshTokenUserCommand);
    }

    @Override
    public LogoutUserResponse logoutUser(LogoutUserEmailCommand logoutUserEmailCommand) {
        return userCommandHandler.logoutUser(logoutUserEmailCommand);
    }

    @Override
    public ChangedPasswordUserResponse changePasswordUser(ChangedPasswordUserCommand changedPasswordUserCommand) {
        return userCommandHandler.changePasswordUser(changedPasswordUserCommand);
    }

    @Override
    public ForgotPasswordEmailResponse forgotPasswordEmail(ForgotPasswordEmailCommand forgotPasswordEmailCommand) throws MessagingException {
        return userCommandHandler.forgotPasswordEmail(forgotPasswordEmailCommand);
    }

    @Override
    public VerifyOTPResponse verifyOTP(VerifyOTPCommand verifyOTPCommand) {
        return userCommandHandler.verifyOTP(verifyOTPCommand);
    }

    @Override
    public ResetPasswordResponse forgotPasswordChangePassword(ResetPasswordCommand forgotPasswordChangePasswordCommand) {
        return userCommandHandler.forgotPasswordChangePassword(forgotPasswordChangePasswordCommand);
    }

    @Override
    public QueryGeneralStatisticUserResponse getStatisticUser() {
        return userCommandHandler.getStatisticUser();
    }

    @Override
    public QueryGeneralStatisticUserResponse getStatisticUserAdminOrg(String orgId) {
        return userCommandHandler.getStatisticUserAdminOrg(orgId);
    }
}
