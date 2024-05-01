package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison;

import lombok.Builder;

import javax.validation.constraints.NotNull;
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
        UUID examId,
        @NotNull(message = "User id is required")
        UUID userId
) {
}
