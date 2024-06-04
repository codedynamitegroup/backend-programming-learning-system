package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison
 * Create by Dang Ngoc Tien
 * Date 6/4/2024 - 2:35 PM
 * Description: ...
 */
public record CreateQuestionSubmit(
        UUID questionId,
        String content,
        Integer numFile
) {
}
