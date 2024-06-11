package com.backend.programming.learning.system.course.service.domain.dto.responseentity.exam;

import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
public record RecentExamResponseEntity(
        UUID id,
        UUID courseId,
        String courseName,
        String examName,
        ZonedDateTime createdAt
) {
}
