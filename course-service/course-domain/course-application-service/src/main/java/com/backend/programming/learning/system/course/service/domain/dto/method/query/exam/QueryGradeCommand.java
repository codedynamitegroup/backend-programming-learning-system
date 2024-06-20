package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam
 * Create by Dang Ngoc Tien
 * Date 6/20/2024 - 4:27 PM
 * Description: ...
 */
@Builder
public record QueryGradeCommand(
        String search,
        @NotNull
        int pageNo,
        @NotNull
        int pageSize
) {
}
