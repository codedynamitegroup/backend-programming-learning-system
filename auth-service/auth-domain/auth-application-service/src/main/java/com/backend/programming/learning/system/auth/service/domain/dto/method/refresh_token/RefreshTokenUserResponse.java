package com.backend.programming.learning.system.auth.service.domain.dto.method.refresh_token;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class RefreshTokenUserResponse {
    @NotNull
    private final String accessToken;

    @NotNull
    private final String refreshToken;
}
