package com.backend.programming.learning.system.course.service.domain.dto.method.query.course;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.RecentAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.exam.RecentExamResponseEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
public record QueryGeneralCourseStatisticsResponse(
        long totalCourse,
        long totalEnrollments,
        long activeCourse,
        long inactiveCourse,

        List<QueryLineChartResponse> userEnrollments,
        List<QueryLineChartResponse> newCourses,
        List<QueryPieChartResponse> activeInactiveCourse,
        List<QueryPieChartResponse> courseType,
        List<RecentExamResponseEntity> recentExam,
        List<RecentAssignmentResponseEntity> recentAssignments
        ) {
}
