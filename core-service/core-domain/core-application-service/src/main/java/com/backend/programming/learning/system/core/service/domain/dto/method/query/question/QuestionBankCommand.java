package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.core.service.domain.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 7/21/2024 - 12:17 AM
 * Description: ...
 */
public record QuestionBankCommand(
        List<UUID> questionIds,
        UUID categoryId
) {
}
