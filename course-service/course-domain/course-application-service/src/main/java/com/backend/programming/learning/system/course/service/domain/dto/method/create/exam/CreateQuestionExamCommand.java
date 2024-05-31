package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.create.exam
 * Create by Dang Ngoc Tien
 * Date 5/30/2024 - 12:27 AM
 * Description: ...
 */
public record CreateQuestionExamCommand(
        UUID questionId,
        Integer page
) {
}
