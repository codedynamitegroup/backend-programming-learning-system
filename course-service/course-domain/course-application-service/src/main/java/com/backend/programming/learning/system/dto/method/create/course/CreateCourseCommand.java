package com.backend.programming.learning.system.dto.method.create.course;

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
        @NotNull(message = "Name is required") String name, String key,
        @NotNull(message = "Visible is required") Boolean visible,
        @NotNull(message = "Created by is required") UUID createdBy) {

}
