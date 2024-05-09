package com.backend.programming.learning.system.auth.service.application.rest;

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
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.KeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/auth/users", produces = "application/vnd.api.v1+json")
public class UserController {

    private final UserApplicationService userApplicationService;
    private final KeycloakApplicationService keycloakApplicationService;

    public UserController(UserApplicationService userApplicationService, KeycloakApplicationService keycloakApplicationService) {
        this.userApplicationService = userApplicationService;
        this.keycloakApplicationService = keycloakApplicationService;
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
    public ResponseEntity<?> createUser(@RequestBody CreateUserCommand createUserCommand) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            String token = jwtAuthenticationToken.getToken().getTokenValue();
            log.info("Creating user with email: {}", createUserCommand.getEmail());
            CreateUserResponse createUserResponse = userApplicationService.createUser(createUserCommand, token);
            log.info("User created with email: {}", createUserResponse.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponse);
        }
        return ResponseEntity.badRequest().body("Token is not valid.");
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
        log.info("Logging user with username: {}", loginUserCommand.getUsername());
        LoginUserResponse loginUserResponse = userApplicationService.loginUser(loginUserCommand);
        return ResponseEntity.status(HttpStatus.OK).body(loginUserResponse);
    }

    @PostMapping("/refresh_token")
    @Operation(summary = "Refresh token user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = RefreshTokenUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<RefreshTokenUserResponse> refreshTokenUser(
            @RequestParam String refreshToken
    ) {
        RefreshTokenUserResponse refreshTokenUser = userApplicationService.refreshTokenUser(
                RefreshTokenUserCommand
                        .builder()
                        .refreshToken(refreshToken)
                        .build()
        );
        return ResponseEntity.status(HttpStatus.OK).body(refreshTokenUser);
    }

    @GetMapping("/search")
    public ResponseEntity<?> findAllUsers(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            String token = jwtAuthenticationToken.getToken().getTokenValue();
            return ResponseEntity.ok(keycloakApplicationService.findAllUsers(token));
        }
        return ResponseEntity.badRequest().body("Token is not valid.");
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

    @PutMapping("/{id}")
    @Operation(summary = "Update user by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<?> updateUserById(@PathVariable UUID id, @RequestBody UpdateUserCommand updateUserCommand) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            String token = jwtAuthenticationToken.getToken().getTokenValue();
            log.info("Updating user with id: {}", id);
            UpdateUserResponse updateUserResponse = userApplicationService.updateUser(UpdateUserCommand.builder()
                    .userId(id)
                    .dob(updateUserCommand.getDob())
                    .firstName(updateUserCommand.getFirstName())
                    .lastName(updateUserCommand.getLastName())
                    .phone(updateUserCommand.getPhone())
                    .address(updateUserCommand.getAddress())
                    .avatarUrl(updateUserCommand.getAvatarUrl())
                    .build(), token);

            log.info("User updated with id: {}", id);
            return ResponseEntity.ok(updateUserResponse);
        }
        return ResponseEntity.badRequest().body("Token is not valid.");
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
    public ResponseEntity<?> deleteUserById(@PathVariable UUID id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            String token = jwtAuthenticationToken.getToken().getTokenValue();
            log.info("Deleting user with id: {}", id);
            DeleteUserResponse deleteUserResponse =
                    userApplicationService.deleteUserById(DeleteUserCommand.builder()
                            .userId(id)
                            .build(), token);
            log.info("User deleted with id: {}", id);
            return ResponseEntity.ok(deleteUserResponse);
        }
        return ResponseEntity.badRequest().body("Token is not valid.");
    }
}
