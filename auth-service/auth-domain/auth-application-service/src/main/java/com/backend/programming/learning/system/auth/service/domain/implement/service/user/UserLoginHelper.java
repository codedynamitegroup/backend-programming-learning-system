package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.ResponseLoginAndRefreshUser;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
public class UserLoginHelper {
    private final KeycloakConfigData keycloakConfigData;

    public UserLoginHelper(KeycloakConfigData keycloakConfigData) {
        this.keycloakConfigData = keycloakConfigData;
    }

    public LoginUserResponse loginUser(LoginUserCommand loginUserCommand) {
        WebClient client = WebClient.create(keycloakConfigData.getUrls());

        ResponseLoginAndRefreshUser result = client.post()
                .uri("realms/" + keycloakConfigData.getRealm() + "/protocol/openid-connect/token")
                .accept(MediaType.APPLICATION_FORM_URLENCODED)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(loginUserCommandToRequestBody(loginUserCommand)))
                .retrieve()
                .bodyToMono(ResponseLoginAndRefreshUser.class)
                .block();
        if (result == null) {
            log.error("Login failed");
            throw new AuthDomainException("Login failed");
        }
        return LoginUserResponse.builder()
                .accessToken(result.getAccess_token())
                .refreshToken(result.getRefresh_token())
                .build();
    }

    private MultiValueMap<String, String> loginUserCommandToRequestBody(LoginUserCommand loginUserCommand) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", keycloakConfigData.getClient());
        formData.add("client_secret", keycloakConfigData.getClientSecret());
        formData.add("username", loginUserCommand.getUsername());
        formData.add("password", loginUserCommand.getPassword());
        formData.add("grant_type", "password");
        return formData;
    }
}
