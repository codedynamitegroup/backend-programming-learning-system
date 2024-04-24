package com.backend.programming.learning.system.dto.method.create.question_bank;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 3:42 PM
 * Description: ...
 */
@Builder
public record CreateQuestionBankCommand(
        @NotNull(message = "Organization id is required")
        UUID organizationId,
        @NotNull(message = "Question difficulty is required")
        QuestionDifficulty difficulty,
        @NotNull(message = "Question name is required")
        String name,
        String questionText,
        String generalFeedback,
        Float defaultMark,
        @NotNull(message = "Question type is required")
        QuestionType qtype,
        @NotNull(message = "Is question bank is required")
        UUID questionBankCategoryId,
        @NotNull(message = "Created by is required")
        UUID createdBy
) {
}
