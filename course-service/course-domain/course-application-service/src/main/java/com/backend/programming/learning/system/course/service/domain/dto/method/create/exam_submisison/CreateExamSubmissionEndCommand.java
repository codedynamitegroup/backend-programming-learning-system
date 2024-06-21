package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison;

import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
public record CreateExamSubmissionEndCommand(
        UUID examId,
        UUID userId,
        ZonedDateTime examSubmissionTime
) {
}
