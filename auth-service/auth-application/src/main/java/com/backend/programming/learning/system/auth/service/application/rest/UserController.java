package com.backend.programming.learning.system.auth.service.application.rest;

import com.backend.programming.learning.system.auth.service.application.utils.JwtUtils;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.SocialLoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.logout.LogoutUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.logout.LogoutUserEmailCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.logout.LogoutUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.*;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserEmailCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/auth/users", produces = "application/vnd.api.v1+json")
public class UserController {
    private final UserApplicationService userApplicationService;
    private final JwtUtils jwtUtils;

    public UserController(UserApplicationService userApplicationService, JwtUtils jwtUtils) {
        this.userApplicationService = userApplicationService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping
    @Operation(summary = "Create user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserCommand createUserCommand) {
        log.info("Creating user with email: {}", createUserCommand.getEmail());
        CreateUserResponse createUserResponse = userApplicationService.createUser(createUserCommand);
        log.info("User created with email: {}", createUserResponse.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponse);
    }

    @PostMapping("/register")
    @Operation(summary = "Register user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateUserResponse> registeredUser(@RequestBody CreateUserCommand createUserCommand) {
        log.info("Registering user with email: {}", createUserCommand.getEmail());
        CreateUserResponse createUserResponse = userApplicationService.createUser(createUserCommand);
        log.info("User Registered with email: {}", createUserResponse.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponse);
    }

    @PostMapping("/login")
    @Operation(summary = "Login user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = LoginUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<LoginUserResponse> loginUser(@RequestBody LoginUserCommand loginUserCommand) {
        log.info("Logging user with email: {}", loginUserCommand.getEmail());
        LoginUserResponse loginUserResponse = userApplicationService.loginUser(loginUserCommand);
        return ResponseEntity.status(HttpStatus.OK).body(loginUserResponse);
    }

    @PostMapping("/social-login")
    @Operation(summary = "Socal login user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = LoginUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<LoginUserResponse> socialLoginUser(@RequestBody SocialLoginUserCommand socialLoginUserCommand) {
        LoginUserResponse loginUserResponse = userApplicationService.socialLoginUser(
                SocialLoginUserCommand.builder()
                        .provider(socialLoginUserCommand.getProvider())
                        .accessToken(socialLoginUserCommand.getAccessToken())
                        .build());
        return ResponseEntity.status(HttpStatus.OK).body(loginUserResponse);
    }

    @PostMapping("/refresh-token")
    @Operation(summary = "Refresh token user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = RefreshTokenUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<?> refreshTokenUser(@RequestBody RefreshTokenUserCommand refreshTokenUserCommand) {
        String email = jwtUtils.getEmailFromJwtStringWithoutCheckExp(refreshTokenUserCommand.getAccessToken());
        if (email == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Invalid access token"));
        }
        RefreshTokenUserResponse refreshTokenUser = userApplicationService.refreshTokenUser(
                RefreshTokenUserEmailCommand.builder()
                        .email(email)
                        .refreshToken(refreshTokenUserCommand.getRefreshToken())
                        .build());
        return ResponseEntity.status(HttpStatus.OK).body(refreshTokenUser);
    }

    @PostMapping("/logout")
    @Operation(summary = "Logout user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = RefreshTokenUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<?> logoutUser(@RequestHeader(value = "Access-Token", required = false) String accessToken) {
        String email = jwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);
        if (email == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Invalid access token"));
        }
        LogoutUserResponse logoutUserResponse = userApplicationService.logoutUser(
                LogoutUserEmailCommand.builder()
                        .email(email)
                        .build());
        return ResponseEntity.status(HttpStatus.OK).body(logoutUserResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UserEntityResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UserEntityResponse> getUserById(@PathVariable UUID id) {
        UserEntityResponse user =
               userApplicationService.findUserById(QueryUserByIdCommand.builder().userId(id).build());
       log.info("Returning user with id: {}", user.getUserId());
       return  ResponseEntity.ok(user);
    }

    @GetMapping("/get-by-email/{email}")
    @Operation(summary = "Get user by email.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UserEntityResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UserEntityResponse> getUserByEmail(@PathVariable String email) {
        UserEntityResponse user =
                userApplicationService.findUserByEmail(QueryUserByEmailCommand.builder().email(email).build());
        log.info("Returning user with id: {}", user.getUserId());
        return  ResponseEntity.ok(user);
    }

    @GetMapping
    @Operation(summary = "Get all users.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllUsersResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllUsersResponse> getAllUsers(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        QueryAllUsersResponse users = userApplicationService.findAllUsers(QueryAllUsersCommand.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .build());
        log.info("Returning all users");
        return ResponseEntity.ok(users);
    }

    @GetMapping("/organizations/{organizationId}")
    @Operation(summary = "Get all users by organization.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllUsersResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllUsersResponse> getAllUsersByOrganization(
            @PathVariable UUID organizationId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        QueryAllUsersResponse users = userApplicationService.findAllUsersByOrganization(QueryAllUsersByOrganizationCommand.builder()
                .organizationId(organizationId)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .build());
        log.info("Returning all users from organization with id: {}.", organizationId);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateUserResponse> updateUserById(
            @PathVariable UUID id,
            @RequestBody UpdateUserCommand updateUserCommand) {
        log.info("Updating user with id: {}", id);
        UpdateUserResponse updateUserResponse = userApplicationService.updateUser(UpdateUserCommand.builder()
                .userId(id)
                .dob(updateUserCommand.getDob())
                .firstName(updateUserCommand.getFirstName())
                .lastName(updateUserCommand.getLastName())
                .phone(updateUserCommand.getPhone())
                .address(updateUserCommand.getAddress())
                .avatarUrl(updateUserCommand.getAvatarUrl())
                .build());

        log.info("User updated with id: {}", id);
        return ResponseEntity.ok(updateUserResponse);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteUserResponse> deleteUserById(
            @PathVariable UUID id) {
        log.info("Deleting user with id: {}", id);
        DeleteUserResponse deleteUserResponse =
                userApplicationService.deleteUserById(DeleteUserCommand.builder()
                        .userId(id)
                        .build());
        log.info("User deleted with id: {}", id);
        return ResponseEntity.ok(deleteUserResponse);
    }
}
