package com.backend.programming.learning.system.dto.method.query.question_bank_category;

import com.backend.programming.learning.system.dto.responseentity.question_bank_category.QuestionBankCategoryEntity;
import lombok.Builder;

import java.util.List;

/**
 * com.backend.programming.learning.system.dto.method.query.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:20 AM
 * Description: ...
 */
@Builder
public record QueryAllQuestionBankCategoryResponse(
        List<QuestionBankCategoryEntity> questionBankCategories,
        String message
) {
}
