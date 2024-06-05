package com.backend.programming.learning.system.core.service.domain.dto.method.create.question;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.create.question
 * Create by Dang Ngoc Tien
 * Date 6/4/2024 - 9:16 PM
 * Description: ...
 */
public record CreateQuestionClone(
        UUID questionId,
        String qtype
) {
}
