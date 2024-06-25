package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record ExamQuestionSubmissionCommand(
        @NotNull(message = "Exam id is required")
        @Schema(example = "86600cfb-7b48-4e81-8e05-8fa29d49d7a6")
        UUID examId,

        @NotNull(message = "User id is required")
        @Schema(example = "9ba179ed-d26d-4828-a0f6-8836c2063992")
        UUID userId,
        List<QuestionSubmissionCommand> questionSubmissionCommands
) {
}
