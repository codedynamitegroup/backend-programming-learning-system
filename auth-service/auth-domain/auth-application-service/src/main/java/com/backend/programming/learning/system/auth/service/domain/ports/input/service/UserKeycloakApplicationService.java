package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import org.keycloak.admin.client.resource.UsersResource;

public interface UserKeycloakApplicationService {
    void createUser(CreateUserCommand createUserCommand);
    void deleteUser(User user);
    void updateUser(User user);
    void addFederationLink(String provider, String username, String userIdSSO, String usernameSSO);
    UsersResource getUsersResource();
}
