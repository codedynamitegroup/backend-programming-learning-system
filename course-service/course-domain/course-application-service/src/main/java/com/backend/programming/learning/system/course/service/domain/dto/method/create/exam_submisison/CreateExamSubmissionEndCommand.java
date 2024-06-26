package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
public record CreateExamSubmissionEndCommand(
        @NotNull(message = "Exam id is required")
        UUID examId,

        @NotNull(message = "User id is required")
        UUID userId,

        @NotNull(message = "Exam submission time is required")
        @NotBlank(message = "Exam submission time must not be blank")
        ZonedDateTime examSubmissionTime
) {
}
