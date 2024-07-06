package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

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
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LinkSSOUserCommand;
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

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

public interface UserApplicationService {
    CreateUserResponse createUserByAdmin(@Valid CreateUserCommand createUserCommand);
    CreateUserResponse registerUser(@Valid RegisterUserCommand registerUserCommand);
    UserEntityResponse findUserById(@Valid QueryUserByIdCommand queryUserCommand);
    AssignUserToOrganizationResponse assignUserToOrganization(@Valid AssignUserToOrganizationCommand assignUserToOrganizationCommand);
    UnassignedUserToOrganizationResponse unassignedUserToOrganization(@Valid UnassignedUserToOrganizationCommand unassignedUserToOrganizationCommand);
    UserEntityResponse findUserByIdAndIsDeletedTrueOrFalse(@Valid QueryUserByIdCommand queryUserCommand);
    UserEntityResponse findUserByEmail(@Valid QueryUserByEmailCommand queryUserByEmailCommand);
    UserEntityResponse findUserByEmailAndIsDeletedTrueOrFalse(QueryUserByEmailCommand queryUserByEmailCommand);
    QueryAllUsersResponse findAllUsers(QueryAllUsersCommand queryAllUsersCommand);
    QueryAllUsersResponse findAllUsersByOrganization(QueryAllUsersByOrganizationCommand queryAllUsersByOrganizationCommand);
    UpdateUserResponse updateUserProfile(@Valid UpdateUserProfileCommand updateUserCommand);
    UpdateUserResponse updateUserByAdmin(@Valid UpdateUserByAdminCommand updateUserCommand);
    DeleteUserResponse deleteUserById(@Valid DeleteUserCommand deleteUserCommand);
    LoginUserResponse loginUser(@Valid LoginUserCommand loginUserCommand);
    LoginUserResponse socialLoginUser(@Valid SocialLoginUserCommand socialLoginUserCommand);
    void linkSSO(@Valid LinkSSOUserCommand linkSSOUserCommand);
    RefreshTokenUserResponse refreshTokenUser(@Valid RefreshTokenUserEmailCommand refreshTokenUserEmailCommand);
    LogoutUserResponse logoutUser(@Valid LogoutUserEmailCommand logoutUserEmailCommand);
    ChangedPasswordUserResponse changePasswordUser(@Valid ChangedPasswordUserCommand changedPasswordUserCommand);
    ForgotPasswordEmailResponse forgotPasswordEmail(@Valid ForgotPasswordEmailCommand forgotPasswordEmailCommand) throws MessagingException;
    VerifyOTPResponse verifyOTP(@Valid VerifyOTPCommand verifyOTPCommand);
    ResetPasswordResponse forgotPasswordChangePassword(
            @Valid ResetPasswordCommand forgotPasswordChangePasswordCommand);

    QueryGeneralStatisticUserResponse getStatisticUser();

    QueryGeneralStatisticUserResponse getStatisticUserAdminOrg(String orgId);
}
