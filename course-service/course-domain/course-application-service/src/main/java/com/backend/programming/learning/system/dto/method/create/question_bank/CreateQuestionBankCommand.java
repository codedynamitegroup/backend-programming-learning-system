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
@Getter
@Builder
@AllArgsConstructor
public class CreateQuestionBankCommand {
    private UUID organizationId;
    @NotNull(message = "Question difficulty is required")
    private QuestionDifficulty difficulty;
    @NotNull(message = "Question name is required")
    private String name;
    private String questionText;
    private String generalFeedback;
    private Float defaultMark;
    @NotNull(message = "Question type is required")
    private QuestionType qtype;
    @NotNull(message = "Is question bank is required")
    private UUID questionBankCategoryId;
    @NotNull(message = "Created by is required")
    private UUID createdBy;
}
