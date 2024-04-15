package com.backend.programming.learning.system.auth.service.domain.dto.query;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryUserCommand {
    @NotNull
    private final UUID userId;
}
