package com.backend.programming.learning.system.auth.service.application.rest;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/auth/users", produces = "application/vnd.api.v1+json")
public class UserController {

    private final UserApplicationService userApplicationService;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserCommand createUserCommand) {
        log.info("Creating user with email: {}", createUserCommand.getEmail());
        CreateUserResponse createUserResponse = userApplicationService.createUser(createUserCommand);
        log.info("User created with email: {}", createUserResponse.getEmail());
        return ResponseEntity.ok(createUserResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QueryUserResponse> getUserById(@PathVariable UUID id) {
        QueryUserResponse queryUserResponse =
               userApplicationService.findUserById(QueryUserCommand.builder().userId(id).build());
       log.info("Returning user with email: {}", queryUserResponse.getEmail());
       return  ResponseEntity.ok(queryUserResponse);
    }

    @GetMapping
    public ResponseEntity<List<QueryUserResponse>> getAllUsers() {
        List<QueryUserResponse> queryUserResponse = userApplicationService.findAllUsers();
        log.info("Returning all users");
        return ResponseEntity.ok(queryUserResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteUserResponse> deleteUserById(@PathVariable UUID id) {
        log.info("Deleting user with id: {}", id);
        DeleteUserResponse deleteUserResponse =
                userApplicationService.deleteUserById(DeleteUserCommand.builder().userId(id).build());
        log.info("User deleted with id: {}", id);
        return ResponseEntity.ok(deleteUserResponse);
    }
}
