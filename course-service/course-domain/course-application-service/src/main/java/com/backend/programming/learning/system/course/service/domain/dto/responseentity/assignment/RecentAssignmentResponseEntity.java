package com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment;

import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
public record RecentAssignmentResponseEntity(
        UUID id,
        UUID courseId,
        String courseName,
        String title,
        String type,
        ZonedDateTime createdAt
) {
}
