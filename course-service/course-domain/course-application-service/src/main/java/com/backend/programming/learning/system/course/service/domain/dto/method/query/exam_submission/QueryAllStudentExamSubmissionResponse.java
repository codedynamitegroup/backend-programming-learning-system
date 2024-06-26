package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission;

import lombok.Builder;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission
 * Create by Dang Ngoc Tien
 * Date 6/24/2024 - 10:47 PM
 * Description: ...
 */
@Builder
public record QueryAllStudentExamSubmissionResponse(
        List<QueryStudentExamSubmissionResponse> studentExamSubmissionResponses,
        int currentPage,
        long totalItems,
        int totalPages
) {
}
