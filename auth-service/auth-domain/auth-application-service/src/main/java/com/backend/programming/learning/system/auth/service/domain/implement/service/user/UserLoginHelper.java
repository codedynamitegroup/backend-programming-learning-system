package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.LoginUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.ResponseLoginAndRefreshUser;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
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
public class UserLoginHelper {
    private final KeycloakConfigData keycloakConfigData;
    private final UserRepository userRepository;


    public UserLoginHelper(KeycloakConfigData keycloakConfigData, UserRepository userRepository) {
        this.keycloakConfigData = keycloakConfigData;
        this.userRepository = userRepository;
    }

    @Transactional
    public LoginUserResponse loginUser(LoginUserCommand loginUserCommand) {
        User user = findUserByEmail(loginUserCommand.getEmail());
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

        user.setRefreshToken(result.getRefresh_token());
        saveUser(user);

        return LoginUserResponse.builder()
                .accessToken(result.getAccess_token())
                .build();
    }

    public User findUserByEmail(String email) {
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

    private MultiValueMap<String, String> loginUserCommandToRequestBody(LoginUserCommand loginUserCommand) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", keycloakConfigData.getClient());
        formData.add("client_secret", keycloakConfigData.getClientSecret());
        formData.add("username", loginUserCommand.getEmail());
        formData.add("password", loginUserCommand.getPassword());
        formData.add("grant_type", "password");
        return formData;
    }
}
