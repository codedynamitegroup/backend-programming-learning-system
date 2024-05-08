package com.backend.programming.learning.system.course.service.domain.dto.method.create.question;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.question.create
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:05 PM
 * Description: ...
 */
@Builder
public record CreateQuestionCommand(
        @NotNull(message = "Organization id is required")
        UUID organizationId,
        @NotNull(message = "Question difficulty is required")
        QuestionDifficulty difficulty,
        @NotNull(message = "Question name is required")
        String name,
        String questionText,
        String generalFeedback,
        Float defaultMark,
        UUID questionBankCategoryId,
        @NotNull(message = "Question type is required")
        QuestionType qtype,
        @NotNull(message = "Created by is required")
        UUID createdBy
) {
}
