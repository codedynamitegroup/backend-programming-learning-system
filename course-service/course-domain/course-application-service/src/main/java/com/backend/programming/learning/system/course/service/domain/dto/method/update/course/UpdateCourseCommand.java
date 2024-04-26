package com.backend.programming.learning.system.course.service.domain.dto.method.update.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.delete.update.course
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 10:22 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class UpdateCourseCommand {
    private UUID courseId;
    @NotNull(message = "Course name is required")
    private String name;
    @NotNull(message = "Course description is required")
    private Boolean visible;
    @NotNull(message = "Course updated by is required")
    private UUID updatedBy;
}
