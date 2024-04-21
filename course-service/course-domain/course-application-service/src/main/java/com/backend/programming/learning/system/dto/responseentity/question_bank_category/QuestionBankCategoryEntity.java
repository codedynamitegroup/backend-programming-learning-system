package com.backend.programming.learning.system.dto.responseentity.question_bank_category;

import lombok.Builder;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.responseentity.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:21 AM
 * Description: ...
 */
@Builder
public record QuestionBankCategoryEntity(
        UUID questionBankCategoryId,
        UUID questionBankId,
        String name
) {
}
