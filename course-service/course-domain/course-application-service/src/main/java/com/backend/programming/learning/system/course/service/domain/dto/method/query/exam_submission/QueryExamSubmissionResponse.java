package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission;

import com.backend.programming.learning.system.course.service.domain.valueobject.Status;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission
 * Create by Dang Ngoc Tien
 * Date 6/5/2024 - 9:44 PM
 * Description: ...
 */
@Builder
public record QueryExamSubmissionResponse(
        UUID examSubmissionId,
        UUID examId,
        UUID userId,
        UUID courseId,
        String courseName,
        String name,
        String intro,
        Integer attemptCount,
        Float maxScores,
        ZonedDateTime startTime,
        ZonedDateTime endTime,
        ZonedDateTime submitTime,
        Status status,
        Float grade,
        List<QuestionSubmissionResponse> questionSubmissionResponses
) {
}
