package com.backend.programming.learning.system.core.service.domain.dto.method.query.contest;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_user.ContestUserResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryLeaderboardOfContestResponse {
    private final ContestUserResponseEntity participantRank;
    private final List<ContestUserResponseEntity> contestLeaderboard;
    private final int currentPage;
    private final long totalItems;
    private final int totalPages;
}
