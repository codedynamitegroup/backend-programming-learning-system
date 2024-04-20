package com.backend.programming.learning.system.dto.method.delete.course_user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.delete.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 12:05 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class DeleteCourseUserCommand {
    private List<UUID> userIds;
    private UUID courseId;
}
