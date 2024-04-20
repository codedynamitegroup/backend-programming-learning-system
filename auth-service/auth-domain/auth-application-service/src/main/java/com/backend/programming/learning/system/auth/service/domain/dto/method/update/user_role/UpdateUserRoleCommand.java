package com.backend.programming.learning.system.auth.service.domain.dto.method.update.user_role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateUserRoleCommand {
    @NotNull
    private UUID userRoleId;

    private String name;

    private Boolean isActive;

    @NotNull
    private final UUID updatedBy;
}
