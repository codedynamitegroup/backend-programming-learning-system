package com.backend.programming.learning.system.dto.method.create.question;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.question.create
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:05 PM
 * Description: ...
 */
@Getter
@Builder
public class CreateQuestionCommand {
    private UUID organizationId;
    @NotNull(message = "Question difficulty is required")
    private QuestionDifficulty difficulty;
    @NotNull(message = "Question name is required")
    private String name;
    private String questionText;
    private String generalFeedback;
    private Float defaultMark;
    private UUID questionBankCategoryId;
    @NotNull(message = "Question type is required")
    private QuestionType qtype;
    @NotNull(message = "Created by is required")
    private UUID createdBy;
}
