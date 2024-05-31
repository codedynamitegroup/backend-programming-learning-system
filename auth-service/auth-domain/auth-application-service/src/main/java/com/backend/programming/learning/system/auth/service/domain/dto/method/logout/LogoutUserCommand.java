package com.backend.programming.learning.system.auth.service.domain.dto.method.logout;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class LogoutUserCommand {
    @NotNull
    private final String accessToken;
}
