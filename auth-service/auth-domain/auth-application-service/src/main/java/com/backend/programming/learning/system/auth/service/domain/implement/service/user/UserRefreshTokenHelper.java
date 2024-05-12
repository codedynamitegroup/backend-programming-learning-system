package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.ResponseLoginAndRefreshUser;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserResponse;
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
public class UserRefreshTokenHelper {
    private final KeycloakConfigData keycloakConfigData;

    public UserRefreshTokenHelper(KeycloakConfigData keycloakConfigData) {
        this.keycloakConfigData = keycloakConfigData;
    }

    public RefreshTokenUserResponse refreshTokenUser(RefreshTokenUserCommand refreshTokenUserCommand) {
        WebClient client = WebClient.create(keycloakConfigData.getUrls());

        ResponseLoginAndRefreshUser result = client.post()
                .uri("realms/" + keycloakConfigData.getRealm() + "/protocol/openid-connect/token")
                .accept(MediaType.APPLICATION_FORM_URLENCODED)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(refreshTokenUserCommandToRequestBody(refreshTokenUserCommand)))
                .retrieve()
                .bodyToMono(ResponseLoginAndRefreshUser.class)
                .block();
        if (result == null) {
            log.error("Refresh token failed");
            throw new AuthDomainException("Refresh token failed");
        }
        return RefreshTokenUserResponse.builder()
                .accessToken(result.getAccess_token())
                .refreshToken(result.getRefresh_token())
                .build();
    }

    private MultiValueMap<String, String> refreshTokenUserCommandToRequestBody(RefreshTokenUserCommand refreshTokenUserCommand) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", keycloakConfigData.getClient());
        formData.add("client_secret", keycloakConfigData.getClientSecret());
        formData.add("refresh_token", refreshTokenUserCommand.getRefreshToken());
        formData.add("grant_type", "refresh_token");
        return formData;
    }
}
