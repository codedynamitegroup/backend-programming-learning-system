package com.backend.programming.learning.system.dto.method.create.question_submission;

import lombok.Builder;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.question_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 1:18 AM
 * Description: ...
 */
@Builder
public record CreateQuestionSubmissionResponse(
        UUID questionSubmissionId,
        UUID examSubmissionId,
        UUID questionId,
        UUID userId,
        Integer passStatus,
        Float grade,
        String content,
        String rightAnswer,
        Integer numFile
) {
}
