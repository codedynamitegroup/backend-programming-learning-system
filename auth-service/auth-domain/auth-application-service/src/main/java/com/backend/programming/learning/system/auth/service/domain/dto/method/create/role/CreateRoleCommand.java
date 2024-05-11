package com.backend.programming.learning.system.auth.service.domain.dto.method.create.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateRoleCommand {
    @NotNull
    private final String name;

    private String description;

    @NotNull
    private final UUID createdBy;
}
