package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam;

import lombok.Builder;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam
 * Create by Dang Ngoc Tien
 * Date 6/20/2024 - 4:30 PM
 * Description: ...
 */
@Builder
public record QueryAllGradeResponse(
        List<QueryGradeResponse> grades,
        int currentPage,
        long totalItems,
        int totalPages
) {
}
