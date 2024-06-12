package com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission
 * Create by Dang Ngoc Tien
 * Date 6/12/2024 - 12:38 AM
 * Description: ...
 */
public record MarkQuestionSubmissionCommand(
//        @NotNull(message = "Exam submission id is required")
        UUID examSubmissionId,
//        @NotNull(message = "Question id is required")
        UUID questionId,
//        @NotNull(message = "Grade is required")
        Float grade,
        String rightAnswer
) {
}
