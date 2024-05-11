package com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserRoleResponse {
    @NotNull
    private UUID userRoleId;

    @NotNull
    private final String message;
}
