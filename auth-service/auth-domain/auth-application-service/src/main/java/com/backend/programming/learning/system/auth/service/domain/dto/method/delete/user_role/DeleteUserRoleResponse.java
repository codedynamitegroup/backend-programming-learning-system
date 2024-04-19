package com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteUserRoleResponse {
    @NotNull
    private final UUID roleId;

    @NotNull
    private final UUID userId;

    @NotNull
    private final String message;
}
