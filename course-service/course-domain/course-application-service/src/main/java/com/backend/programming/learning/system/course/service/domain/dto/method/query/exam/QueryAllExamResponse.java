package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.exam.ExamResponseEntity;
import lombok.Builder;

import java.util.List;

/**
 * com.backend.programming.learning.system.dto.method.query.exam
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 9:00 PM
 * Description: ...
 */
@Builder
public record QueryAllExamResponse(
        List<ExamResponseEntity> exams,
        int currentPage,
        long totalItems,
        int totalPages
) {
}
