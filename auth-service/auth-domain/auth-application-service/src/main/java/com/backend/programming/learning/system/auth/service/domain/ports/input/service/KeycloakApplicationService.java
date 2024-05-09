package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import org.keycloak.representations.idm.UserRepresentation;
import java.util.List;

public interface KeycloakApplicationService {
    List<UserRepresentation> findAllUsers(String token);
    void createUser(CreateUserCommand createUserCommand, String token);
    void deleteUser(User user, String token);
    void updateUser(User user, String token);
}
