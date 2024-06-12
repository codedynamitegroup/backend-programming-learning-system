package com.backend.programming.learning.system.auth.service.domain.implement.service.keycloak;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.RegisterUserCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.util.KeycloakProvider;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.FederatedIdentityRepresentation;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.keycloak.admin.client.resource.*;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;


@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class UserKeycloakApplicationServiceImpl implements UserKeycloakApplicationService {
    private final KeycloakProvider keycloakProvider;
    private final KeycloakConfigData keycloakConfigData;

    @Override
    public UsersResource getUsersResource() {
        RealmResource realmResource = keycloakProvider.getRealmResource().realm(keycloakConfigData.getRealm());
        return realmResource.users();
    }

    @Override
    public void updatePassword(String email, String newPassword) {
        UsersResource usersResource = getUsersResource();
        List<UserRepresentation> userRepresentations = usersResource.searchByUsername(email, true);
        if (userRepresentations.isEmpty()) {
            log.error("User not found");
            throw new AuthDomainException("User not found");
        }
        UserRepresentation userRepresentation = userRepresentations.get(0);

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setValue(newPassword);
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);

        List<CredentialRepresentation> list = new ArrayList<>();
        list.add(credentialRepresentation);
        userRepresentation.setCredentials(list);

        usersResource.get(userRepresentation.getId()).update(userRepresentation);

    }

    @Override
    public void createUserByAdmin(CreateUserCommand createUserCommand) {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setFirstName(createUserCommand.getFirstName());
        userRepresentation.setLastName(createUserCommand.getLastName());
        userRepresentation.setEmail(createUserCommand.getEmail());
        userRepresentation.setUsername(createUserCommand.getEmail());
        userRepresentation.setEnabled(true);
        userRepresentation.setEmailVerified(false);

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setValue(createUserCommand.getPassword());
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);

        List<CredentialRepresentation> list = new ArrayList<>();
        list.add(credentialRepresentation);
        userRepresentation.setCredentials(list);

        UsersResource usersResource = getUsersResource();
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
    public void registerUser(RegisterUserCommand registerUserCommand) {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setFirstName(registerUserCommand.getFirstName());
        userRepresentation.setLastName(registerUserCommand.getLastName());
        userRepresentation.setEmail(registerUserCommand.getEmail());
        userRepresentation.setUsername(registerUserCommand.getEmail());
        userRepresentation.setEnabled(true);
        userRepresentation.setEmailVerified(false);

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setValue(registerUserCommand.getPassword());
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);

        List<CredentialRepresentation> list = new ArrayList<>();
        list.add(credentialRepresentation);
        userRepresentation.setCredentials(list);

        UsersResource usersResource = getUsersResource();
        Response response = usersResource.create(userRepresentation);

        if (Objects.equals(201, response.getStatus())) {
            log.info("User created with username: {}", registerUserCommand.getEmail());
        }  else if (Objects.equals(409, response.getStatus())) {
            log.error("User exist already!");
            throw new AuthDomainException("User exist already!");
        } else {
            log.error("Error creating user, please contact with the administrator.");
            throw new AuthDomainException("Error creating user, please contact with the administrator.");
        }
    }

    @Override
    public void deleteUser(User user) {
        UsersResource usersResource = getUsersResource();
        List<UserRepresentation> userRepresentations = usersResource.searchByUsername(user.getUsername(), true);
        if (userRepresentations.isEmpty()) {
            log.error("User not found");
            throw new AuthDomainException("User not found");
        }
        UserRepresentation userRepresentation = userRepresentations.get(0);
        userRepresentation.setEnabled(false);
        usersResource.get(userRepresentation.getId()).update(userRepresentation);
    }

    @Override
    public void updateUser(User user) {
        UsersResource usersResource = getUsersResource();
        List<UserRepresentation> userRepresentations = usersResource.searchByUsername(user.getUsername(), true);
        if (userRepresentations.isEmpty()) {
            log.error("User not found");
            throw new AuthDomainException("User not found");
        }
        UserRepresentation userRepresentation = userRepresentations.get(0);
        userRepresentation.setFirstName(user.getFirstName());
        userRepresentation.setLastName(user.getLastName());
        usersResource.get(userRepresentation.getId()).update(userRepresentation);
    }

    @Override
    public void addFederationLink(String provider, String username, String userIdSSO, String usernameSSO) {
        UsersResource usersResource = getUsersResource();
        List<UserRepresentation> userRepresentations = usersResource.searchByUsername(username, true);
        if (userRepresentations.isEmpty()) {
            log.error("User not found");
            throw new AuthDomainException("User not found");
        }
        if (!provider.equals("google") && !provider.equals("microsoft")) {
            log.error("Provider not found");
            throw new AuthDomainException("Provider not found");
        }
        UserRepresentation userRepresentation = userRepresentations.get(0);
        FederatedIdentityRepresentation federatedIdentityRepresentation = new FederatedIdentityRepresentation();
        federatedIdentityRepresentation.setUserId(userIdSSO);
        federatedIdentityRepresentation.setUserName(usernameSSO);
        federatedIdentityRepresentation.setIdentityProvider(provider);
        Response response = usersResource.get(userRepresentation.getId()).addFederatedIdentity(provider, federatedIdentityRepresentation);
        log.info("Federation link added with status: {}", response.getStatus());
    }

}
