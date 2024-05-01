package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.exam_submisison
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:14 AM
 * Description: ...
 */
public record CreateExamSubmissionCommand(
        @NotNull(message = "Exam submission id is required")
        UUID examSubmissionId
//        @NotNull(message = "Exam id is required")
//        UUID examId,
//        @NotNull(message = "User id is required")
//        UUID userId,
//        @NotNull(message = "Type is required")
//        Type type,
//        @NotNull(message = "Pass status is required")
//        Status passStatus
) {
}
