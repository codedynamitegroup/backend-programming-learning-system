package com.backend.programming.learning.system.dto.method.delete.course_user;

import lombok.Builder;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.delete.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 12:05 PM
 * Description: ...
 */
@Builder
public record DeleteCourseUserCommand(
        @NotNull(message = "User ids is required")
        List<UUID> userIds,
        @NotNull(message = "Course id is required")
        UUID courseId
) {
}
