package com.backend.programming.learning.system.core.service.domain.dto.method.query.contest;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.QueryLineChartResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record QueryGeneralStatisticsContestResponse(
        long totalContest,
        long totalParticipants,
        long activeContest,
        long closedContest,
        long upcomingContest,
        List<QueryLineChartResponse> participantTrend,
        List<QueryLineChartResponse> popularContest,
        String[] popularContestName
) {

}
