package com.backend.programming.learning.system.dto.method.create.course_user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 10:07 AM
 * Description: ...
 */
@Builder
public record CreateCourseUserCommand(
        @NotNull(message = "User ids are required") List<UUID> userIds,
        @NotNull(message = "Course id is required") UUID courseId
) {
}
