package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import com.backend.programming.learning.system.auth.service.domain.dto.method.change_password.ChangedPasswordUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.change_password.ChangedPasswordUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.ResponseLoginAndRefreshUser;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
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
public class UserChangedPasswordHelper {
    private final KeycloakConfigData keycloakConfigData;
    private final UserRepository userRepository;
    private final UserKeycloakApplicationService userKeycloakApplicationService;

    public UserChangedPasswordHelper(KeycloakConfigData keycloakConfigData, UserRepository userRepository, UserKeycloakApplicationService userKeycloakApplicationService) {
        this.keycloakConfigData = keycloakConfigData;
        this.userRepository = userRepository;
        this.userKeycloakApplicationService = userKeycloakApplicationService;
    }

    @Transactional
    public ChangedPasswordUserResponse changedPasswordUser(ChangedPasswordUserCommand changedPasswordUserCommand) {
        User user = findUserByEmail(changedPasswordUserCommand.getEmail());
        WebClient client = WebClient.create(keycloakConfigData.getUrls());

        ResponseLoginAndRefreshUser result = client.post()
                .uri("realms/" + keycloakConfigData.getRealm() + "/protocol/openid-connect/token")
                .accept(MediaType.APPLICATION_FORM_URLENCODED)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(loginUserCommandToRequestBody(changedPasswordUserCommand)))
                .retrieve()
                .bodyToMono(ResponseLoginAndRefreshUser.class)
                .block();
        if (result == null) {
            log.error("Old password is incorrect!");
            throw new AuthDomainException("Login failed");
        }

        userKeycloakApplicationService.updatePassword(user.getEmail(), changedPasswordUserCommand.getNewPassword());

        return ChangedPasswordUserResponse.builder()
                .message("Password is changed successfully!")
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

    private MultiValueMap<String, String> loginUserCommandToRequestBody(ChangedPasswordUserCommand changedPasswordUserCommand) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", keycloakConfigData.getClient());
        formData.add("client_secret", keycloakConfigData.getClientSecret());
        formData.add("username", changedPasswordUserCommand.getEmail());
        formData.add("password", changedPasswordUserCommand.getOldPassword());
        formData.add("grant_type", "password");
        return formData;
    }
}
