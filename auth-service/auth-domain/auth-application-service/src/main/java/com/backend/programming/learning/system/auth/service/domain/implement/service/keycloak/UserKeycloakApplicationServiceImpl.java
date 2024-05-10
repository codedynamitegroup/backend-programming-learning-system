package com.backend.programming.learning.system.auth.service.domain.implement.service.keycloak;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.util.KeycloakProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.keycloak.admin.client.resource.*;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import javax.ws.rs.core.Response;


@Slf4j
@Validated
@Service
public class UserKeycloakApplicationServiceImpl implements UserKeycloakApplicationService {
    private final KeycloakProvider keycloakProvider;
    private final KeycloakConfigData keycloakConfigData;

    public UserKeycloakApplicationServiceImpl(KeycloakProvider keycloakProvider, KeycloakConfigData keycloakConfigData) {
        this.keycloakProvider = keycloakProvider;
        this.keycloakConfigData = keycloakConfigData;
    }

    public UsersResource getUserResource(String token) {
        RealmResource realmResource = keycloakProvider.getRealmResource(token).realm(keycloakConfigData.getRealm());
        return realmResource.users();
    }

    @Override
    public void createUser(CreateUserCommand createUserCommand, String token) {
        UsersResource usersResource = getUserResource(token);

        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setFirstName(createUserCommand.getFirstName());
        userRepresentation.setLastName(createUserCommand.getLastName());
        userRepresentation.setEmail(createUserCommand.getEmail());
        userRepresentation.setUsername(createUserCommand.getUsername());
        userRepresentation.setEnabled(true);
        userRepresentation.setEmailVerified(false);

        CredentialRepresentation credentialRepresentation=new CredentialRepresentation();
        credentialRepresentation.setValue(createUserCommand.getPassword());
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);

        List<CredentialRepresentation> list = new ArrayList<>();
        list.add(credentialRepresentation);
        userRepresentation.setCredentials(list);

        Response response = usersResource.create(userRepresentation);

        if (Objects.equals(201, response.getStatus())) {
            log.info("User created with username: {}", createUserCommand.getUsername());
        }  else if (Objects.equals(409, response.getStatus())) {
            log.error("User exist already!");
            throw new AuthDomainException("User exist already!");
        } else {
            log.error("Error creating user, please contact with the administrator.");
            throw new AuthDomainException("Error creating user, please contact with the administrator.");
        }
    }

    @Override
    public void deleteUser(User user, String token) {
        UsersResource usersResource = getUserResource(token);
        UserRepresentation userRepresentation = usersResource.searchByUsername(user.getUsername(), true).get(0);
        userRepresentation.setEnabled(false);
        usersResource.get(userRepresentation.getId()).update(userRepresentation);
    }

    @Override
    public void updateUser(User user, String token) {
        UsersResource usersResource = getUserResource(token);
        UserRepresentation userRepresentation = usersResource.searchByUsername(user.getUsername(), true).get(0);
        userRepresentation.setFirstName(user.getFirstName());
        userRepresentation.setLastName(user.getLastName());
        usersResource.get(userRepresentation.getId()).update(userRepresentation);
    }
}
