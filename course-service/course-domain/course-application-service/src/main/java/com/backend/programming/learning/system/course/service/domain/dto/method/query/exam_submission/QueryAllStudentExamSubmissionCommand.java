package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission
 * Create by Dang Ngoc Tien
 * Date 6/24/2024 - 10:52 PM
 * Description: ...
 */
@Builder
public record QueryAllStudentExamSubmissionCommand(
        @NotNull
        Integer pageNo,
        @NotNull
        Integer pageSize,
        String search
) {
}
