package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.ResponseLoginAndRefreshUser;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.SocialLoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.SocialLoginUserProfileCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
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

    public UserSocialLoginHelper(KeycloakConfigData keycloakConfigData, UserCreateHelper userCreateHelper, UserRepository userRepository) {
        this.keycloakConfigData = keycloakConfigData;
        this.userCreateHelper = userCreateHelper;
        this.userRepository = userRepository;
    }

    @Transactional
    public LoginUserResponse socialLoginUser(SocialLoginUserProfileCommand socialLoginUserProfileCommand) {
        WebClient client = WebClient.create(keycloakConfigData.getUrls());



//        ResponseLoginAndRefreshUser result = client.post()
//                .uri("realms/" + keycloakConfigData.getGoogleRealm() + "/protocol/openid-connect/token")
//                .accept(MediaType.APPLICATION_FORM_URLENCODED)
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .body(BodyInserters.fromFormData(socialLoginUserCommandToRequestBody(socialLoginUserProfileCommand)))
//                .retrieve()
//                .bodyToMono(ResponseLoginAndRefreshUser.class)
//                .block();

//        if (result == null) {
//            log.error("Login failed");
//            throw new AuthDomainException("Login failed");
//        }

        return LoginUserResponse.builder()
                .accessToken("result.getAccess_token()")
                .build();
    }

    private MultiValueMap<String, String> socialLoginUserCommandToRequestBody(SocialLoginUserProfileCommand socialLoginUserProfileCommand) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", keycloakConfigData.getGoogleClient());
        formData.add("subject_token", socialLoginUserProfileCommand.getAccessToken());
        formData.add("subject_token_type", "urn:ietf:params:oauth:token-type:access_token");
        formData.add("grant_type", "urn:ietf:params:oauth:grant-type:token-exchange");
        formData.add("subject_issuer", socialLoginUserProfileCommand.getProvider());
        return formData;
    }

}
