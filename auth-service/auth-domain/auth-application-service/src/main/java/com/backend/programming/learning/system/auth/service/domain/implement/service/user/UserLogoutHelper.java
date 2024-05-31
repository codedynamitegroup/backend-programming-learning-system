package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.config.KeycloakConfigData;
import com.backend.programming.learning.system.auth.service.domain.dto.method.login.ResponseLoginAndRefreshUser;
import com.backend.programming.learning.system.auth.service.domain.dto.method.logout.LogoutUserEmailCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.logout.LogoutUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserEmailCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token.RefreshTokenUserResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Component
public class UserLogoutHelper {
    private final UserRepository userRepository;

    public UserLogoutHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LogoutUserResponse logoutUser(LogoutUserEmailCommand logoutUserEmailCommand) {
        User user = findUserByEmail(logoutUserEmailCommand.getEmail());
        user.setRefreshToken(null);

        saveUser(user);

        return LogoutUserResponse.builder()
                .message("User is logged out")
                .build();
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
