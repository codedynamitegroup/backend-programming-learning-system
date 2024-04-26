package com.backend.programming.learning.system.dto.method.create.exam_submisison;

import com.backend.programming.learning.system.valueobject.Status;
import com.backend.programming.learning.system.valueobject.Type;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.exam_submisison
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:15 AM
 * Description: ...
 */
@Builder
public record CreateExamSubmissionResponse(
        UUID examSubmissionId,
        UUID examId,
        UUID userId,
        ZonedDateTime startTime,
        ZonedDateTime submitTime,
        Status status
) {
}
