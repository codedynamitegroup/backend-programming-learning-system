package com.backend.programming.learning.system.auth.service.domain.dto.method.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserRoleCommand {
    @NotNull
    private final UUID roleId;

    @NotNull
    private final UUID userId;

    @NotNull
    private String name;

    @NotNull
    private final UUID createdBy;

    @NotNull
    private final UUID updatedBy;
}
