package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import org.keycloak.admin.client.resource.UsersResource;

public interface UserKeycloakApplicationService {
    void createUser(CreateUserCommand createUserCommand, String token);
    void deleteUser(User user, String token);
    void updateUser(User user, String token);
    UsersResource getUsersResource(String token);
}
