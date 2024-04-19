package com.backend.programming.learning.system.auth.service.domain.dto.method.create.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateRoleCommand {
    @NotNull
    private final UUID organizationId;

    @NotNull
    private final String name;

    @NotNull
    private final UUID createdBy;

    @NotNull
    private final UUID updatedBy;
}
