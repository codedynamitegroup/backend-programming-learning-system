package com.backend.programming.learning.system.auth.service.domain.dto.method.query.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllUsersCommand {
    @NotNull
    private final int pageNo;

    @NotNull
    private final int pageSize;
}
