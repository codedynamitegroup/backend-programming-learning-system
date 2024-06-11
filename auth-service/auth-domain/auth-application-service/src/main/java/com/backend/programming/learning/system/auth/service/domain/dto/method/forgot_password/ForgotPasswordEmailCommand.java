package com.backend.programming.learning.system.auth.service.domain.dto.method.forgot_password;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ForgotPasswordEmailCommand {
    @NotNull
    private final String email;

    @NotNull
    private final String redirectUrl;
}
