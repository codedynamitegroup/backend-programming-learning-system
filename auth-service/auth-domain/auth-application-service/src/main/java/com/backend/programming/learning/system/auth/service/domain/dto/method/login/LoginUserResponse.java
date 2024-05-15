package com.backend.programming.learning.system.auth.service.domain.dto.method.login;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class LoginUserResponse {
    @NotNull
    private final String accessToken;
}
