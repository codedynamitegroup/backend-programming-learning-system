package com.backend.programming.learning.system.auth.service.domain.util;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakProvider {
    private final KeycloakConfigData keycloakConfigData;
    private static final String USER_CONSOLE = "admin";
    private static final String PASSWORD_CONSOLE = "admin";

    public KeycloakProvider(KeycloakConfigData keycloakConfigData) {
        this.keycloakConfigData = keycloakConfigData;
    }

    public Keycloak getRealmResource(String token) {
        return KeycloakBuilder.builder()
                .serverUrl(keycloakConfigData.getUrls())
                .realm(keycloakConfigData.getRealm())
                .clientId(keycloakConfigData.getAdminClientId())
                .clientSecret(keycloakConfigData.getClientSecret())
                .username(USER_CONSOLE)
                .password(PASSWORD_CONSOLE)
                .authorization("Bearer " + token)
                .resteasyClient(new ResteasyClientBuilderImpl()
                        .connectionPoolSize(10)
                        .build())
                .build();
    }
}
