package com.backend.programming.learning.system.course.service.domain.dto.method.delete.course;

import lombok.Builder;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.delete.course
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 11:01 AM
 * Description: ...
 */
@Builder
public record DeleteCourseCommand(
        @NotNull(message = "Course id is required")
        UUID courseId
) {
}
