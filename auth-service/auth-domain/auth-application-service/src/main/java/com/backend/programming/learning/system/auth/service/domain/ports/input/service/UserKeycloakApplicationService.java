package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.RegisterUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import org.keycloak.admin.client.resource.UsersResource;

public interface UserKeycloakApplicationService {
    void createUserByAdmin(CreateUserCommand createUserCommand);
    void registerUser(RegisterUserCommand registerUserCommand);
    void deleteUser(User user);
    void updateUser(User user);
    void addFederationLink(String provider, String username, String userIdSSO, String usernameSSO);
    UsersResource getUsersResource();
    void updatePassword(String email, String newPassword);
}
