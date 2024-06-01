package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam;

import lombok.Builder;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam
 * Create by Dang Ngoc Tien
 * Date 6/1/2024 - 4:01 AM
 * Description: ...
 */
@Builder
public record QueryOverviewResponse(
        Integer numberOfStudents,
        Integer submitted,
        Integer needGrading
) {
}
