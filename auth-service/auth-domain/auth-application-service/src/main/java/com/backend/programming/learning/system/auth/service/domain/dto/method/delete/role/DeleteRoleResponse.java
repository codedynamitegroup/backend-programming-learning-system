package com.backend.programming.learning.system.auth.service.domain.dto.method.delete.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteRoleResponse {
    @NotNull
    private final UUID roleId;

    @NotNull
    private final String message;
}
