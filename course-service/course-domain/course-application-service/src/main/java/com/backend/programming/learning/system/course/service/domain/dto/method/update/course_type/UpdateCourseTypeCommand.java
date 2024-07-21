package com.backend.programming.learning.system.course.service.domain.dto.method.update.course_type;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UpdateCourseTypeCommand(
        @NotNull(message = "Id is required")
        UUID id,

        @NotNull(message = "Name is required")
        String name) {
}
