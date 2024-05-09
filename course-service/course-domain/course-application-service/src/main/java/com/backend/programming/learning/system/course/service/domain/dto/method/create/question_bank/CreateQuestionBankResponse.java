package com.backend.programming.learning.system.course.service.domain.dto.method.create.question_bank;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 3:42 PM
 * Description: ...
 */
@Builder
public record CreateQuestionBankResponse(
        UUID organizationId,
        QuestionDifficulty difficulty,
        String name,
        String questionText,
        String generalFeedback,
        Float defaultMark,
        QuestionType qtype,
        UUID questionBankCategoryId,
        UUID createdBy,
        String message
) {
}
