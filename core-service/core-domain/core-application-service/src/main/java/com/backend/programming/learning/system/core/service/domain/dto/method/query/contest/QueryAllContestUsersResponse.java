package com.backend.programming.learning.system.core.service.domain.dto.method.query.contest;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_user.ContestUserResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllContestUsersResponse {
    @NotNull
    private final List<ContestUserResponseEntity> contestUsers;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
