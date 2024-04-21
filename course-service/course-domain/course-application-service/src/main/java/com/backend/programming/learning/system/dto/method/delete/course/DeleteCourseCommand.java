package com.backend.programming.learning.system.dto.method.delete.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.delete.course
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 11:01 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class DeleteCourseCommand {
    private final UUID courseId;
}
