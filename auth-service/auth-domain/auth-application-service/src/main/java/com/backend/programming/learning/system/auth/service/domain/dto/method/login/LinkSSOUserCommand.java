package com.backend.programming.learning.system.auth.service.domain.dto.method.login;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LinkSSOUserCommand {
    @NotNull
    private final String accessToken;

    @NotNull
    private final String provider;

    @NotNull
    private final String email;
}
