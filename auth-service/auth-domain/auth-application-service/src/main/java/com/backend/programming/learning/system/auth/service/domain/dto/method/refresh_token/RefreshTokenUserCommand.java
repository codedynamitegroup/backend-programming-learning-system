package com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class RefreshTokenUserCommand {
    @NotNull
    private final String refreshToken;

    private final String accessToken;
}
