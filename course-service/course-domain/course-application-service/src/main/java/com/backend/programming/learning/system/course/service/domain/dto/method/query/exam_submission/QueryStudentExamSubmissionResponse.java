package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission
 * Create by Dang Ngoc Tien
 * Date 6/24/2024 - 10:48 PM
 * Description: ...
 */
@Builder
public record QueryStudentExamSubmissionResponse(
        UUID examSubmissionId,
        UUID examId,
        UUID userId,
        String firstName,
        String lastName,
        String email,
        String status,
        String statusGrade,
        Double mark,
        Double totalMark,
        Double grade,
        Double totalGrade
) {
}
