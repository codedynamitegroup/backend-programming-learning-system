package com.backend.programming.learning.system.course.service.domain.dto.responseentity.course;

import lombok.Builder;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.responseentity.course
 * Create by Dang Ngoc Tien
 * Date 5/20/2024 - 8:53 AM
 * Description: ...
 */
@Builder
public record UserCourseEntity(
        UUID userId,
        String firstName,
        String lastName,
        String email,
        String role
) {
}
