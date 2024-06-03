package com.backend.programming.learning.system.core.service.domain.dto.method.query.contest;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryStatisticsOfContestCommand {
    @NotNull
    private final UUID contestId;
}
