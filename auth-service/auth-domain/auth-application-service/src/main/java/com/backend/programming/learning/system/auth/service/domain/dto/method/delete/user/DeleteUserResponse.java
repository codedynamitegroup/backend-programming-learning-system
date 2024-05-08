package com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteUserResponse {
    @NotNull
    private final UUID userId;

    @NotNull
    private final String message;
}
