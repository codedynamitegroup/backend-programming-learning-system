package com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserRoleCommand {
    @NotNull
    private final UUID roleId;

    @NotNull
    private final UUID userId;
}
