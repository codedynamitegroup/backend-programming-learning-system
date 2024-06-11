package com.backend.programming.learning.system.auth.service.domain.dto.method.query.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryGeneralStatisticUserResponse {
    private final long totalUsers;
    private final long activeUsers;
    private final long offlineUsers;
    private final long loginToday;
    private final List<QueryLineChartResponse> registerUser;
    private final List<QueryPieChartResponse> userByRole;
}
