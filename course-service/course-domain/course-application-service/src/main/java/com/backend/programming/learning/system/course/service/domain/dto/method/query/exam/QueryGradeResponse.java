package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam;

import lombok.Builder;

import java.time.ZonedDateTime;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam
 * Create by Dang Ngoc Tien
 * Date 6/20/2024 - 4:20 PM
 * Description: ...
 */
@Builder
public record QueryGradeResponse(
        String firstName,
        String lastName,
        String email,
        String status,
        ZonedDateTime lastSubmitAt,
        ZonedDateTime lastMarkAt,
        Float score,
        Float maxScore
) {
}
