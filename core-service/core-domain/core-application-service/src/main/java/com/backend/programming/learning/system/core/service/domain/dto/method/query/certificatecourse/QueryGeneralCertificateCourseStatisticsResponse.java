package com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.QueryLineChartResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.QueryPieChartResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record QueryGeneralCertificateCourseStatisticsResponse(
        long totalCertificateCourse,
        long totalEnrollments,
        double averageRating,
        long totalParticipantCompletedCourse,

        List<QueryLineChartResponse> enrollmentChart,
        List<QueryLineChartResponse> topEnrolledCourse,
        List<QueryPieChartResponse> chapterResourceType
) {
}
