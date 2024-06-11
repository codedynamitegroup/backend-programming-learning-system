package com.backend.programming.learning.system.auth.service.domain.dto.method.query.user;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
public record QueryGeneralStatisticUserResponse(
        long totalUsers,
        long activeUsers,
        long offlineUsers,
        long loginToday,
        List<QueryLineChartResponse> registerUser,
        List<QueryPieChartResponse> userByRole) {
}
