package com.backend.programming.learning.system.course.service.domain.dto.method.create.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
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
        @NotNull(message = "Course type is required")
        String courseType,
        @NotNull(message = "Visible is required")
        Boolean visible,
        @NotNull(message = "Created by is required")
        UUID createdBy) {
}
