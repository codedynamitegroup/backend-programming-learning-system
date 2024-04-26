package com.backend.programming.learning.system.dto.method.delete.exam;

import lombok.Builder;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.delete.exam
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 11:18 AM
 * Description: ...
 */
@Builder
public record DeleteExamCommand(
        @NotNull(message = "Exam id is required")
        UUID examId
) {
}
