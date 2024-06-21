package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.exam_submisison
 * Create by Dang Ngoc Tien
 * Date 4/26/2024 - 12:13 AM
 * Description: ...
 */
@Builder
public record CreateExamSubmissionStartCommand(
        @NotNull(message = "Exam id is required")
        @Schema(example = "86600cfb-7b48-4e81-8e05-8fa29d49d7a6")
        UUID examId,

        @NotNull(message = "User id is required")
        @Schema(example = "9ba179ed-d26d-4828-a0f6-8836c2063992")
        UUID userId,

        @NotNull(message = "Exam start time is required")
        ZonedDateTime examStartTime
) {
}
