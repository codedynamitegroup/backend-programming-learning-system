package com.backend.programming.learning.system.auth.service.domain.dto.method.query.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryUserByIdCommand {
    @NotNull
    private final UUID userId;
}
