package com.backend.programming.learning.system.auth.service.domain.dto.method.create.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateRoleResponse {
    @NotNull
    private UUID roleId;

    @NotNull
    private final String name;
    @NotNull
    private final String message;
}
