package com.backend.programming.learning.system.course.service.domain.dto.method.create.course_type;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateCourseTypeResponse(
        UUID id,

        @NotNull
        String message
) {
}
