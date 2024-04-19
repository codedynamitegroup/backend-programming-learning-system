package com.backend.programming.learning.system.auth.service.domain.dto.method.update.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateRoleCommand {
    @NotNull
    private final UUID roleId;

    private String description;

    private String name;

    @NotNull
    private final UUID updatedBy;
}
