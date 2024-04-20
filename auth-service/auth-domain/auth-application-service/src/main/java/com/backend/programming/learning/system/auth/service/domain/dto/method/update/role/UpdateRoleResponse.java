package com.backend.programming.learning.system.auth.service.domain.dto.method.update.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateRoleResponse {
    @NotNull
    private UUID roleId;

    @NotNull
    private final String message;
}
