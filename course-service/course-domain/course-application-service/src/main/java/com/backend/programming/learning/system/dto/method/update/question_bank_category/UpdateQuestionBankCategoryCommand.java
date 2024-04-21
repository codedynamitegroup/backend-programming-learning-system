package com.backend.programming.learning.system.dto.method.update.question_bank_category;

import lombok.Builder;

import javax.validation.constraints.NotNull;

/**
 * com.backend.programming.learning.system.dto.method.update.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 2:18 AM
 * Description: ...
 */
@Builder
public record UpdateQuestionBankCategoryCommand(
        @NotNull(message = "Question Bank Category Id is required")
        String name
) {
}
