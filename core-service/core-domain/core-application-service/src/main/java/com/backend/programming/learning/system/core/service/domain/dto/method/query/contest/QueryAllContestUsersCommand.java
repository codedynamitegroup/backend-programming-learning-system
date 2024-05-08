package com.backend.programming.learning.system.core.service.domain.dto.method.query.contest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllContestUsersCommand {
    @NotNull
    private final UUID contestId;
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
    @NotNull
    private final Boolean fetchAll;
}
