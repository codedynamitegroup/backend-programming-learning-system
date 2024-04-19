package com.backend.programming.learning.system.auth.service.domain.dto.method.query.user_role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryUserRoleCommand {
    @NotNull
    private final UUID roleId;
    @NotNull
    private final UUID userId;
}
