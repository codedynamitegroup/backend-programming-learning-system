package com.backend.programming.learning.system.dto.method.create.exam_submisison;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.exam_submisison
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:14 AM
 * Description: ...
 */
public record CreateExamSubmissionCommand(
        UUID examId,
        UUID userId,
        String type,
        Integer passStatus
) {
}
