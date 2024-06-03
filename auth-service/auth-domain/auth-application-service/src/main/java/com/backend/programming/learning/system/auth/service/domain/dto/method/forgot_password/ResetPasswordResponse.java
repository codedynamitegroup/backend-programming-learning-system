package com.backend.programming.learning.system.auth.service.domain.dto.method.forgot_password;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResetPasswordResponse {
    @NotNull
    private final String email;

    private final String message;
}
