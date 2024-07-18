package com.backend.programming.learning.system.course.service.domain.dto.method.create.course;

import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @param key @NotNull
 */
@Builder
public record CreateCourseCommand(
        Integer courseIdMoodle,
        @NotNull(message = "Name is required")
        String name,
        String key,

        @NotNull(message = "Organization id is required")
        UUID organizationId,

        @NotNull(message = "Course type is required")
        UUID courseTypeId,
        @NotNull(message = "Visible is required")
        Boolean visible) {
}
