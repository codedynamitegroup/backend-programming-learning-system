package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission;

import lombok.Builder;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission
 * Create by Dang Ngoc Tien
 * Date 6/7/2024 - 6:19 PM
 * Description: ...
 */
@Builder
public record QueryExamSubmissionByUserIdResponse(
        List<QueryExamSubmissionResponse> examSubmissionResponses
) {
}
