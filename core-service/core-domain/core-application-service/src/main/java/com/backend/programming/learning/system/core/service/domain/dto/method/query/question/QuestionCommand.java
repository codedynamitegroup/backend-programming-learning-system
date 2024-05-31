package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.core.service.domain.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 5/31/2024 - 11:24 PM
 * Description: ...
 */

public record QuestionCommand(
        UUID questionId,
        String qtype
) {
}
