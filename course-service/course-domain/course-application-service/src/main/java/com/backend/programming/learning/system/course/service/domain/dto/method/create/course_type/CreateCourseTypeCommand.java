package com.backend.programming.learning.system.course.service.domain.dto.method.create.course_type;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

/**
 * @param key @NotNull
 */
@Builder
public record CreateCourseTypeCommand(
        @NotNull(message = "Name is required")
        String name,

        @NotNull(message = "Organization id is required")
        UUID organizationId) {
}
