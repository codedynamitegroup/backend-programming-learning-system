package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;

public interface UserKeycloakApplicationService {
    void createUser(CreateUserCommand createUserCommand, String token);
    void deleteUser(User user, String token);
    void updateUser(User user, String token);
}
