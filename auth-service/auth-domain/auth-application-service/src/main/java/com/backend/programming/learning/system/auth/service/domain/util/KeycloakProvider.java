package com.backend.programming.learning.system.auth.service.domain.util;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.ResponseLoginAndRefreshUser;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Configuration
public class KeycloakProvider {
    private final KeycloakConfigData keycloakConfigData;

    public KeycloakProvider(KeycloakConfigData keycloakConfigData) {
        this.keycloakConfigData = keycloakConfigData;
    }

    public Keycloak getRealmResource() {
        String accessToken = getServiceAccountAccessToken();
        return KeycloakBuilder.builder()
                .serverUrl(keycloakConfigData.getUrls())
                .realm(keycloakConfigData.getRealm())
                .clientId(keycloakConfigData.getAdminClientId())
                .clientSecret(keycloakConfigData.getClientSecret())
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .authorization(accessToken)
                .build();
    }

    private String getServiceAccountAccessToken() {
        WebClient client = WebClient.create(keycloakConfigData.getUrls());

        ResponseLoginAndRefreshUser result = client.post()
                .uri("realms/" + keycloakConfigData.getRealm() + "/protocol/openid-connect/token")
                .accept(MediaType.APPLICATION_FORM_URLENCODED)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(loginUserCommandToRequestBody()))
                .retrieve()
                .bodyToMono(ResponseLoginAndRefreshUser.class)
                .block();
        if (result == null) {
            throw new AuthDomainException("Something errors, please try again later.");
        }
        return result.getAccess_token();
    }

    private MultiValueMap<String, String> loginUserCommandToRequestBody() {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", keycloakConfigData.getClient());
        formData.add("client_secret", keycloakConfigData.getClientSecret());
        formData.add("username", "admin");
        formData.add("password", "admin");
        formData.add("grant_type", "password");
        return formData;
    }
}
