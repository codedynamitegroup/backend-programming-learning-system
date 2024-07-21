package com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_type;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record DeleteCourseTypeResponse(
        UUID id,

        @NotNull
        String message
) {
}
