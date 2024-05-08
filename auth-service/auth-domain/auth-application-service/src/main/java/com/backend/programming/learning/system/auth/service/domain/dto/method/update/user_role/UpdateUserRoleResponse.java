package com.backend.programming.learning.system.auth.service.domain.dto.method.update.user_role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateUserRoleResponse {
    @NotNull
    private UUID userRoleId;

    @NotNull
    private final String message;
}
