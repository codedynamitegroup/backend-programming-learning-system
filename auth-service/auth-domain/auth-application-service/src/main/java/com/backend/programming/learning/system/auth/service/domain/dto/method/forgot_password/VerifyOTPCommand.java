package com.backend.programming.learning.system.auth.service.domain.dto.method.forgot_password;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class VerifyOTPCommand {
    @NotNull
    private final String email;

    @NotNull
    private final Integer otp;
}
