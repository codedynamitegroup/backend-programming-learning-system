package com.backend.programming.learning.system.course.service.domain.dto.method.create.question_bank_category;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:15 AM
 * Description: ...
 */
public record CreateQuestionBankCategoryCommand(
        UUID organizationId,
        @NotNull(message = "Name is required")
        String name,
        @NotNull(message = "Description is required")
        String description,
        Boolean isOrgQuestionBank,
        @NotNull(message = "Created by is required")
        UUID createdBy
) {
}
