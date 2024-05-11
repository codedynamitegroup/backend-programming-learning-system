package com.backend.programming.learning.system.auth.service.domain.implement.service.keycloak;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.RoleKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.util.KeycloakProvider;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;

@Slf4j
@Validated
@Service
public class RoleKeycloakApplicationServiceImpl implements RoleKeycloakApplicationService {
    private final KeycloakProvider keycloakProvider;
    private final KeycloakConfigData keycloakConfigData;
    private final UserKeycloakApplicationService keycloakUserService;

    public RoleKeycloakApplicationServiceImpl(KeycloakProvider keycloakProvider, KeycloakConfigData keycloakConfigData, UserKeycloakApplicationService keycloakUserService) {
        this.keycloakProvider = keycloakProvider;
        this.keycloakConfigData = keycloakConfigData;
        this.keycloakUserService = keycloakUserService;
    }

    @Override
    public void assignRole(String userName, String roleName, String token) {
        UsersResource usersResource = keycloakUserService.getUsersResource(token);
        UserRepresentation userRepresentation = usersResource.searchByUsername(userName, true).get(0);
        RolesResource rolesResource = getRolesResource(token);
        RoleRepresentation representation = rolesResource.get(roleName).toRepresentation();
        usersResource.get(userRepresentation.getId()).roles().realmLevel().add(Collections.singletonList(representation));
    }
    public RolesResource getRolesResource(String token) {
        return keycloakProvider.getRealmResource(token).realm(keycloakConfigData.getRealm()).roles();
    }
}
