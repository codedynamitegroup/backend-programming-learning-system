package com.backend.programming.learning.system.auth.service.domain.dto.method.update.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateUserResponse {
    @NotNull
    private UUID userId;

    @NotNull
    private final String message;
}
