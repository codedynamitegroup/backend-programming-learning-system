package com.backend.programming.learning.system.course.service.domain.dto.method.update.course_type;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UpdateCourseTypeResponse(
        UUID id,
        @NotNull
        String message
) {
}
