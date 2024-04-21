package com.backend.programming.learning.system.dto.method.create.question_bank_category;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:15 AM
 * Description: ...
 */
public record CreateQuestionBankCategoryCommand(
        @NotNull(message = "Name is required")
        String name,
        UUID questionBankId
) {
}
