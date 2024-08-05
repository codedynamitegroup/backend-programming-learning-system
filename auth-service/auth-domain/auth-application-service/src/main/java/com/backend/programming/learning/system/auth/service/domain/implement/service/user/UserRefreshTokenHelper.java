package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.ResponseLoginAndRefreshUser;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserEmailCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.exception.UnAuthorizedServiceException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Component
public class UserRefreshTokenHelper {
    private final KeycloakConfigData keycloakConfigData;
    private final UserRepository userRepository;

    public UserRefreshTokenHelper(KeycloakConfigData keycloakConfigData, UserRepository userRepository) {
        this.keycloakConfigData = keycloakConfigData;
        this.userRepository = userRepository;
    }

    public RefreshTokenUserResponse refreshTokenUser(RefreshTokenUserEmailCommand refreshTokenUserCommand) {
        try {
            User user = findUserByEmail(refreshTokenUserCommand.getEmail());
//        if (!user.getRefreshToken().equals(refreshTokenUserCommand.getRefreshToken())) {
//            log.error("Refresh token is not matching with the user's refresh token");
//            throw new UnAuthorizedServiceException("Refresh token is not matching with the user's refresh token");
//        }
            if (user.getLinkedWithMicrosoft().equals(Boolean.TRUE) || user.getLinkedWithGoogle().equals(Boolean.TRUE)) {
                WebClient client = WebClient.create(keycloakConfigData.getUrls());

                ResponseLoginAndRefreshUser result = client.post()
                        .uri("realms/" + keycloakConfigData.getRealm() + "/protocol/openid-connect/token")
                        .accept(MediaType.APPLICATION_FORM_URLENCODED)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .body(BodyInserters.fromFormData(refreshTokenUserCommandToRequestBodySSO(user.getRefreshToken())))
                        .retrieve()
                        .bodyToMono(ResponseLoginAndRefreshUser.class)
                        .block();
                if (result == null) {
                    log.error("Refresh token failed");
                    throw new UnAuthorizedServiceException("Refresh token failed");
                }

                user.setRefreshToken(result.getRefresh_token());
                user.setLastLogin(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
                saveUser(user);

                return RefreshTokenUserResponse.builder()
                        .accessToken(result.getAccess_token())
                        .refreshToken(result.getRefresh_token())
                        .build();
            } else {
                WebClient client = WebClient.create(keycloakConfigData.getUrls());

                ResponseLoginAndRefreshUser result = client.post()
                        .uri("realms/" + keycloakConfigData.getRealm() + "/protocol/openid-connect/token")
                        .accept(MediaType.APPLICATION_FORM_URLENCODED)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .body(BodyInserters.fromFormData(refreshTokenUserCommandToRequestBody(user.getRefreshToken())))
                        .retrieve()
                        .bodyToMono(ResponseLoginAndRefreshUser.class)
                        .block();
                if (result == null) {
                    log.error("Refresh token failed");
                    throw new UnAuthorizedServiceException("Refresh token failed");
                }

                user.setRefreshToken(result.getRefresh_token());
                user.setLastLogin(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
                saveUser(user);

                return RefreshTokenUserResponse.builder()
                        .accessToken(result.getAccess_token())
                        .refreshToken(result.getRefresh_token())
                        .build();
            }
        } catch (Exception e) {
            log.error("Refresh token failed");
            throw new UnAuthorizedServiceException("Refresh token failed");
        }
    }


    private MultiValueMap<String, String> refreshTokenUserCommandToRequestBody(String refreshToken) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", keycloakConfigData.getClient());
        formData.add("client_secret", keycloakConfigData.getClientSecret());
        formData.add("refresh_token", refreshToken);
        formData.add("grant_type", "refresh_token");
        return formData;
    }

    private MultiValueMap<String, String> refreshTokenUserCommandToRequestBodySSO(String refreshToken) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", keycloakConfigData.getAuthenticationClientId());
        formData.add("refresh_token", refreshToken);
        formData.add("grant_type", "refresh_token");
        return formData;
    }


    private User findUserByEmail(String email) {
        Optional<User> userResult =
                userRepository.findByEmail(email);
        if (userResult.isEmpty()) {
            log.warn("Could not find user with email: {}", email);
            throw new AuthNotFoundException("Could not find user with email: " +
                    email);
        }
        return userResult.get();
    }

    private User saveUser(User user) {
        User userResult = userRepository.save(user);
        if (userResult == null) {
            log.error("Could not update user!");
            throw new AuthDomainException("Could not update user!");
        }
        log.info("User is updated with id: {}", userResult.getId().getValue());
        return userResult;
    }
}
