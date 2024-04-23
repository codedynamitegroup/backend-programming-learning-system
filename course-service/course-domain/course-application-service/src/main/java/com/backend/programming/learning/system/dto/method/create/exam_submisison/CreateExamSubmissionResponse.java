package com.backend.programming.learning.system.dto.method.create.exam_submisison;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.exam_submisison
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:15 AM
 * Description: ...
 */
public record CreateExamSubmissionResponse(
        UUID examSubmissionId,
        UUID examId,
        UUID userId,
        String type,
        Integer passStatus
) {
}
