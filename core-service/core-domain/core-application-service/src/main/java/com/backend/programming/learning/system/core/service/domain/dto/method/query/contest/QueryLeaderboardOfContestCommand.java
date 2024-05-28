package com.backend.programming.learning.system.core.service.domain.dto.method.query.contest;

import com.backend.programming.learning.system.core.service.domain.valueobject.ContestStartTimeFilter;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryLeaderboardOfContestCommand {
    @NotNull
    private final UUID contestId;
    private final String email;
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
}
