package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserCommand;
import org.keycloak.representations.idm.UserRepresentation;
import javax.validation.Valid;
import java.util.List;

public interface KeycloakApplicationService {
    List<UserRepresentation> findAllUsers(String token);
    void createUser(@Valid CreateUserCommand createUserCommand, String token);
    void deleteUser(@Valid DeleteUserCommand deleteUserCommand, String token);
    void updateUser(@Valid UpdateUserCommand updateUserCommand, String token);
}
