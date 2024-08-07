package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateSocialLoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.*;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.auth_to_any_services.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.UnAuthorizedServiceException;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.user.UserUpdateSagaHelper;
import com.backend.programming.learning.system.auth.service.domain.implement.service.role.RoleQueryHelper;
import com.backend.programming.learning.system.auth.service.domain.implement.service.user_role.UserRoleCreateHelper;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user.UserOutboxHelper;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

import static com.backend.programming.learning.system.saga.user.SagaConstants.AUTH_TO_ANY_SERVICES_USER_SAGA_NAME;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserSocialLoginHelper {
    private final KeycloakConfigData keycloakConfigData;
    private final UserCreateHelper userCreateHelper;
    private final UserRepository userRepository;
    private final UserKeycloakApplicationService userKeycloakApplicationService;
    private final String ROLE_NAME_USER = "user";
    private final RoleQueryHelper roleQueryHelper;
    private final UserRoleCreateHelper userRoleCreateHelper;
    private final UserOutboxHelper userOutboxHelper;
    private final UserUpdateSagaHelper userSagaHelper;
    private final UserDataMapper userDataMapper;

    @Transactional
    public LoginUserResponse socialLoginUser(SocialLoginUserCommand socialLoginUserCommand) {
        if (socialLoginUserCommand.getProvider().equals("google")) {
            SSOGoogleUserProfileResponse userProfileResult = getGoogleUserProfile(socialLoginUserCommand.getAccessToken());

            Optional<User> userResult = userRepository.findByEmail(userProfileResult.getEmail());
            if (userResult.isEmpty()) {
                UserCreatedEvent userCreatedEvent = userCreateHelper.persistUserSocialLogin(CreateSocialLoginUserCommand.builder()
                        .email(userProfileResult.getEmail())
                        .username(userProfileResult.getEmail())
                        .firstName(userProfileResult.getGivenName())
                        .lastName(userProfileResult.getFamilyName())
                        .provider(socialLoginUserCommand.getProvider())
                        .build());

                ResponseLoginAndRefreshUser keycloakLoggedResult = keycloakLogged(socialLoginUserCommand);

                Role role = roleQueryHelper.queryRoleByName(ROLE_NAME_USER);
                userRoleCreateHelper.persistUserRole(CreateUserRoleCommand.builder()
                        .userId(userCreatedEvent.getUser().getId().getValue())
                        .roleId(role.getId().getValue())
                        .build());

                ResponseLoginAndRefreshUser keycloakLoggedResult1 = keycloakLogged(socialLoginUserCommand);

                User user = userCreatedEvent.getUser();
                user.setRefreshToken(keycloakLoggedResult1.getRefresh_token());
                userRepository.save(user);

                userOutboxHelper.saveUserOutboxMessage(
                        AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                        userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                        ServiceName.CORE_SERVICE,
                        CopyState.CREATING,
                        OutboxStatus.STARTED,
                        userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                        UUID.randomUUID());

                userOutboxHelper.saveUserOutboxMessage(
                        AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                        userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                        ServiceName.COURSE_SERVICE,
                        CopyState.CREATING,
                        OutboxStatus.STARTED,
                        userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                        UUID.randomUUID());

                userOutboxHelper.saveUserOutboxMessage(
                        AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                        userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                        ServiceName.CODE_ASSESSMENT_SERVICE,
                        CopyState.CREATING,
                        OutboxStatus.STARTED,
                        userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                        UUID.randomUUID());

                return LoginUserResponse.builder()
                        .accessToken(keycloakLoggedResult1.getAccess_token())
                        .refreshToken(keycloakLoggedResult1.getRefresh_token())
                        .build();
            }

            User userFound = userResult.get();
            if (userFound.getLinkedWithGoogle().equals(Boolean.FALSE)) {
                userKeycloakApplicationService.addFederationLink(socialLoginUserCommand.getProvider(),
                        userFound.getEmail(),
                        userProfileResult.getSub(),
                        userProfileResult.getEmail());

                ResponseLoginAndRefreshUser keycloakLoggedResult = keycloakLogged(socialLoginUserCommand);

                userFound.setRefreshToken(keycloakLoggedResult.getRefresh_token());
                userFound.setLastLogin(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
                userRepository.save(userFound);

                return LoginUserResponse.builder()
                        .accessToken(keycloakLoggedResult.getAccess_token())
                        .refreshToken(keycloakLoggedResult.getRefresh_token())
                        .build();
            } else {
                ResponseLoginAndRefreshUser keycloakLoggedResult = keycloakLogged(socialLoginUserCommand);

                userFound.setRefreshToken(keycloakLoggedResult.getRefresh_token());
                userFound.setLastLogin(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
                userRepository.save(userFound);
                return LoginUserResponse.builder()
                        .accessToken(keycloakLoggedResult.getAccess_token())
                        .refreshToken(keycloakLoggedResult.getRefresh_token())
                        .build();
            }
        } else if (socialLoginUserCommand.getProvider().equals("microsoft")) {
            SSOMicrosoftUserProfileResponse userProfileResult = getMicrosoftUserProfile(socialLoginUserCommand.getAccessToken());

            Optional<User> userResult = userRepository.findByEmail(userProfileResult.getMail());
            if (userResult.isEmpty()) {
                UserCreatedEvent userCreatedEvent = userCreateHelper.persistUserSocialLogin(CreateSocialLoginUserCommand.builder()
                        .email(userProfileResult.getMail())
                        .username(userProfileResult.getUserPrincipalName())
                        .firstName(userProfileResult.getGivenName())
                        .lastName(userProfileResult.getSurname())
                        .provider(socialLoginUserCommand.getProvider())
                        .build());

                ResponseLoginAndRefreshUser keycloakLoggedResult = keycloakLogged(socialLoginUserCommand);

                Role role = roleQueryHelper.queryRoleByName(ROLE_NAME_USER);
                userRoleCreateHelper.persistUserRole(CreateUserRoleCommand.builder()
                        .userId(userCreatedEvent.getUser().getId().getValue())
                        .roleId(role.getId().getValue())
                        .build());

                ResponseLoginAndRefreshUser keycloakLoggedResult1 = keycloakLogged(socialLoginUserCommand);

                User user = userCreatedEvent.getUser();
                user.setRefreshToken(keycloakLoggedResult1.getRefresh_token());
                userRepository.save(user);

                userOutboxHelper.saveUserOutboxMessage(
                        AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                        userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                        ServiceName.CORE_SERVICE,
                        CopyState.CREATING,
                        OutboxStatus.STARTED,
                        userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                        UUID.randomUUID());

                userOutboxHelper.saveUserOutboxMessage(
                        AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                        userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                        ServiceName.COURSE_SERVICE,
                        CopyState.CREATING,
                        OutboxStatus.STARTED,
                        userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                        UUID.randomUUID());

                userOutboxHelper.saveUserOutboxMessage(
                        AUTH_TO_ANY_SERVICES_USER_SAGA_NAME,
                        userDataMapper.userCreatedEventToUserEventPayload(userCreatedEvent),
                        ServiceName.CODE_ASSESSMENT_SERVICE,
                        CopyState.CREATING,
                        OutboxStatus.STARTED,
                        userSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                        UUID.randomUUID());

                return LoginUserResponse.builder()
                        .accessToken(keycloakLoggedResult1.getAccess_token())
                        .refreshToken(keycloakLoggedResult1.getRefresh_token())
                        .build();
            }

            User userFound = userResult.get();
            if (userFound.getLinkedWithMicrosoft().equals(Boolean.FALSE)) {
                userKeycloakApplicationService.addFederationLink(socialLoginUserCommand.getProvider(),
                        userFound.getEmail(),
                        userProfileResult.getId(),
                        userProfileResult.getMail());

                ResponseLoginAndRefreshUser keycloakLoggedResult = keycloakLogged(socialLoginUserCommand);

                userFound.setRefreshToken(keycloakLoggedResult.getRefresh_token());
                userFound.setLastLogin(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
                userRepository.save(userFound);

                return LoginUserResponse.builder()
                        .accessToken(keycloakLoggedResult.getAccess_token())
                        .refreshToken(keycloakLoggedResult.getRefresh_token())
                        .build();
            } else {
                ResponseLoginAndRefreshUser keycloakLoggedResult = keycloakLogged(socialLoginUserCommand);

                userFound.setRefreshToken(keycloakLoggedResult.getRefresh_token());
                userFound.setLastLogin(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
                userRepository.save(userFound);
                return LoginUserResponse.builder()
                        .accessToken(keycloakLoggedResult.getAccess_token())
                        .refreshToken(keycloakLoggedResult.getRefresh_token())
                        .build();
            }
        } else {
            log.error("Provider not supported");
            throw new AuthDomainException("Provider not supported");
        }
    }

    @Transactional
    public void linkSSOProvider(LinkSSOUserCommand linkSSOUserCommand) {
        if (linkSSOUserCommand.getProvider().equals("google")) {
            SSOGoogleUserProfileResponse userProfileResult = getGoogleUserProfile(linkSSOUserCommand.getAccessToken());

            Optional<User> userResult = userRepository.findByEmail(linkSSOUserCommand.getEmail());

            if (userResult.isEmpty()) {
                throw new AuthDomainException("User not found");
            }
            else if (userResult.get().getLinkedWithGoogle().equals(Boolean.TRUE)) {
                throw new AuthDomainException("User already linked with google");
            }
           else if (userResult.get().getEmail().equals(userProfileResult.getEmail())) {
                throw new AuthDomainException("User already linked with google");
            }
            User userFound = userResult.get();
            if (userFound.getLinkedWithGoogle().equals(Boolean.FALSE)) {
                userKeycloakApplicationService.addFederationLink(linkSSOUserCommand.getProvider(),
                        userFound.getEmail(),
                        userProfileResult.getSub(),
                        userProfileResult.getEmail());

                userFound.setLinkedWithGoogle(Boolean.TRUE);
                userFound.setEmailLinkedGoogle(userProfileResult.getEmail());
                userFound.setLastLogin(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
                userRepository.save(userFound);

                return;
            } else {
                throw new AuthDomainException("User already linked with google");
            }
        } else if (linkSSOUserCommand.getProvider().equals("microsoft")) {
            SSOMicrosoftUserProfileResponse userProfileResult = getMicrosoftUserProfile(linkSSOUserCommand.getAccessToken());

            Optional<User> userResult = userRepository.findByEmail(linkSSOUserCommand.getEmail());

            if (userResult.isEmpty()) {
                throw new AuthDomainException("User not found");
            }
            else if (userResult.get().getLinkedWithMicrosoft().equals(Boolean.TRUE)) {
                throw new AuthDomainException("User already linked with google");
            }
            else if (userResult.get().getEmail().equals(userProfileResult.getMail())) {
                throw new AuthDomainException("User already linked with google");
            }
            User userFound = userResult.get();
            if (userFound.getLinkedWithMicrosoft().equals(Boolean.FALSE)) {
                userKeycloakApplicationService.addFederationLink(linkSSOUserCommand.getProvider(),
                        userFound.getEmail(),
                        userProfileResult.getId(),
                        userProfileResult.getMail());

                userFound.setLastLogin(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
                userFound.setLinkedWithMicrosoft(Boolean.TRUE);
                userFound.setEmailLinkedMicrosoft(userProfileResult.getMail());
                userRepository.save(userFound);

                return;
            } else {
                throw new AuthDomainException("User already linked with google");
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
            throw new UnAuthorizedServiceException("Logged keycloak failed");
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
            throw new UnAuthorizedServiceException("Login by google account failed");
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
            throw new UnAuthorizedServiceException("Login by microsoft account failed");
        }

        return userProfileResult;
    }
}
