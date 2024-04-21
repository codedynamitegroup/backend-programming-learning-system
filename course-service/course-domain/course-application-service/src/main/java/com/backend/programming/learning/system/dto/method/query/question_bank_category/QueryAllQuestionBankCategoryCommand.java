package com.backend.programming.learning.system.dto.method.query.question_bank_category;

import lombok.Builder;

import javax.validation.constraints.NotNull;

/**
 * com.backend.programming.learning.system.dto.method.query.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:18 AM
 * Description: ...
 */
@Builder
public record QueryAllQuestionBankCategoryCommand(
        @NotNull
        Integer pageNo,
        @NotNull
        Integer pageSize,
        @NotNull
        String search
) {
}
