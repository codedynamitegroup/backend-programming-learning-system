package com.backend.programming.learning.system.dto.method.update.question_bank_category;

import lombok.Builder;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.update.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 2:19 AM
 * Description: ...
 */
@Builder
public record UpdateQuestionBankCategoryResponse(
        UUID questionBankCategoryId,
        String name,
        UUID questionBankId,
        String message
) {
}
