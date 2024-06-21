package com.backend.programming.learning.system.course.service.domain.dto.method.query.question_submission;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record QueryQuestionSubmissionCommand(
        @NotNull(message = "Exam id is required")
        @Schema(example = "86600cfb-7b48-4e81-8e05-8fa29d49d7a6")
        UUID examId,

        @NotNull(message = "User id is required")
        @Schema(example = "9ba179ed-d26d-4828-a0f6-8836c2063992")
        UUID userId,

        @NotNull(message = "Question submission list is required")
        @Schema(example = "[\"c4b3219f-9d83-4497-ad15-d46772141bd5\"]")
        List<UUID> questionSubmissionIds
) { }
