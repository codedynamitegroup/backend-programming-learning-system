package com.backend.programming.learning.system.dto.method.create.course_user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 10:07 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class CreateCourseUserCommand {
    private List<UUID> userIds;
    private UUID courseId;
}
