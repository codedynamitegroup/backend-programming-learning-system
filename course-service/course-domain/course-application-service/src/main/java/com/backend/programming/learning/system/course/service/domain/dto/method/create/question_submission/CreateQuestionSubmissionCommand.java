package com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.question_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 1:17 AM
 * Description: ...
 */
public record CreateQuestionSubmissionCommand(
        @NotNull(message = "Exam submission id is required")
        UUID examSubmissionId,
        @NotNull(message = "Question id is required")
        UUID questionId,
        @NotNull(message = "User id is required")
        UUID userId,
        @NotNull(message = "Content is required")
        String content,
        Integer numFile
) {
}
