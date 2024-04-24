package com.backend.programming.learning.system.dto.method.create.exam_submisison;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.exam_submisison
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:14 AM
 * Description: ...
 */
public record CreateExamSubmissionCommand(
        @NotNull(message = "Exam id is required")
        UUID examId,
        @NotNull(message = "User id is required")
        UUID userId,
        @NotNull(message = "Type is required")
        String type,
        @NotNull(message = "Pass status is required")
        Integer passStatus
) {
}
