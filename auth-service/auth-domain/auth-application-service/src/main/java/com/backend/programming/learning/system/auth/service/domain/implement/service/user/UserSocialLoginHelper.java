package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateSocialLoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.*;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Slf4j
@Component
public class UserSocialLoginHelper {
    private final KeycloakConfigData keycloakConfigData;
    private final UserCreateHelper userCreateHelper;
    private final UserRepository userRepository;
    private final UserKeycloakApplicationService userKeycloakApplicationService;

    public UserSocialLoginHelper(KeycloakConfigData keycloakConfigData, UserCreateHelper userCreateHelper, UserRepository userRepository, UserKeycloakApplicationService userKeycloakApplicationService) {
        this.keycloakConfigData = keycloakConfigData;
        this.userCreateHelper = userCreateHelper;
        this.userRepository = userRepository;
        this.userKeycloakApplicationService = userKeycloakApplicationService;
    }

    @Transactional
    public LoginUserResponse socialLoginUser(SocialLoginUserCommand socialLoginUserCommand) {
        if (socialLoginUserCommand.getProvider().equals("google")) {
            SSOGoogleUserProfileResponse userProfileResult = getGoogleUserProfile(socialLoginUserCommand.getAccessToken());

            Optional<User> userResult = userRepository.findByEmail(userProfileResult.getEmail());
            if (userResult.isEmpty()) {
                userCreateHelper.persistUserSocialLogin(CreateSocialLoginUserCommand.builder()
                        .email(userProfileResult.getEmail())
                        .username(userProfileResult.getEmail())
                        .firstName(userProfileResult.getGivenName())
                        .lastName(userProfileResult.getFamilyName())
                        .provider(socialLoginUserCommand.getProvider())
                        .build());

                ResponseLoginAndRefreshUser keycloakLoggedResult = keycloakLogged(socialLoginUserCommand);

                return LoginUserResponse.builder()
                        .accessToken(keycloakLoggedResult.getAccess_token())
                        .build();
            }

            User userFound = userResult.get();
            if (userFound.getLinkedWithGoogle().equals(Boolean.FALSE)) {
                userKeycloakApplicationService.addFederationLink(socialLoginUserCommand.getProvider(),
                        userFound.getEmail(),
                        userProfileResult.getSub(),
                        userProfileResult.getEmail());

                ResponseLoginAndRefreshUser keycloakLoggedResult = keycloakLogged(socialLoginUserCommand);

                userFound.setLinkedWithGoogle(Boolean.TRUE);
                userRepository.save(userFound);

                return LoginUserResponse.builder()
                        .accessToken(keycloakLoggedResult.getAccess_token())
                        .build();
            } else {
                ResponseLoginAndRefreshUser keycloakLoggedResult = keycloakLogged(socialLoginUserCommand);

                return LoginUserResponse.builder()
                        .accessToken(keycloakLoggedResult.getAccess_token())
                        .build();
            }
        } else if (socialLoginUserCommand.getProvider().equals("microsoft")) {
            SSOMicrosoftUserProfileResponse userProfileResult = getMicrosoftUserProfile(socialLoginUserCommand.getAccessToken());

            Optional<User> userResult = userRepository.findByEmail(userProfileResult.getMail());
            if (userResult.isEmpty()) {
                userCreateHelper.persistUserSocialLogin(CreateSocialLoginUserCommand.builder()
                        .email(userProfileResult.getMail())
                        .username(userProfileResult.getUserPrincipalName())
                        .firstName(userProfileResult.getGivenName())
                        .lastName(userProfileResult.getSurname())
                        .provider(socialLoginUserCommand.getProvider())
                        .build());

                ResponseLoginAndRefreshUser keycloakLoggedResult = keycloakLogged(socialLoginUserCommand);

                return LoginUserResponse.builder()
                        .accessToken(keycloakLoggedResult.getAccess_token())
                        .build();
            }

            User userFound = userResult.get();
            if (userFound.getLinkedWithMicrosoft().equals(Boolean.FALSE)) {
                userKeycloakApplicationService.addFederationLink(socialLoginUserCommand.getProvider(),
                        userFound.getEmail(),
                        userProfileResult.getId(),
                        userProfileResult.getMail());

                ResponseLoginAndRefreshUser keycloakLoggedResult = keycloakLogged(socialLoginUserCommand);

                userFound.setLinkedWithMicrosoft(Boolean.TRUE);
                userRepository.save(userFound);

                return LoginUserResponse.builder()
                        .accessToken(keycloakLoggedResult.getAccess_token())
                        .build();
            } else {
                ResponseLoginAndRefreshUser keycloakLoggedResult = keycloakLogged(socialLoginUserCommand);

                return LoginUserResponse.builder()
                        .accessToken(keycloakLoggedResult.getAccess_token())
                        .build();
            }
        } else {
            log.error("Provider not supported");
            throw new AuthDomainException("Provider not supported");
        }
    }

    private ResponseLoginAndRefreshUser keycloakLogged(SocialLoginUserCommand socialLoginUserCommand) {
        WebClient keycloakClient = WebClient.create(keycloakConfigData.getUrls());
        ResponseLoginAndRefreshUser result = keycloakClient.post()
                .uri("realms/" + keycloakConfigData.getRealm() + "/protocol/openid-connect/token")
                .accept(MediaType.APPLICATION_FORM_URLENCODED)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(socialLoginUserCommandToRequestBody(socialLoginUserCommand)))
                .retrieve()
                .bodyToMono(ResponseLoginAndRefreshUser.class)
                .block();

        if (result == null) {
            log.error("Logged keycloak failed");
            throw new AuthDomainException("Logged keycloak failed");
        }

        return result;
    }

    private MultiValueMap<String, String> socialLoginUserCommandToRequestBody(SocialLoginUserCommand socialLoginUserCommand) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", keycloakConfigData.getAuthenticationClientId());
        formData.add("subject_token", socialLoginUserCommand.getAccessToken());
        formData.add("subject_token_type", "urn:ietf:params:oauth:token-type:access_token");
        formData.add("grant_type", "urn:ietf:params:oauth:grant-type:token-exchange");
        formData.add("subject_issuer", socialLoginUserCommand.getProvider());
        return formData;
    }

    private SSOGoogleUserProfileResponse getGoogleUserProfile(String accessToken) {
        WebClient googleClient = WebClient.create(keycloakConfigData.getGoogleUrl());

        SSOGoogleUserProfileResponse userProfileResult = googleClient.get()
                .uri("/oauth2/v3/userinfo")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(SSOGoogleUserProfileResponse.class)
                .block();

        if (userProfileResult == null) {
            log.error("Login google account failed");
            throw new AuthDomainException("Login by google account failed");
        }

        return userProfileResult;
    }

    private SSOMicrosoftUserProfileResponse getMicrosoftUserProfile(String accessToken) {
        WebClient microsoftClient = WebClient.create(keycloakConfigData.getMicrosoftUrl());

        SSOMicrosoftUserProfileResponse userProfileResult = microsoftClient.get()
                .uri("/v1.0/me")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(SSOMicrosoftUserProfileResponse.class)
                .block();

        if (userProfileResult == null) {
            log.error("Login microsoft account failed");
            throw new AuthDomainException("Login by microsoft account failed");
        }

        return userProfileResult;
    }
}
