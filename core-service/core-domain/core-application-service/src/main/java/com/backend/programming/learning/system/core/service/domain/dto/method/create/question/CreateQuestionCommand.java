package com.backend.programming.learning.system.core.service.domain.dto.method.create.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class CreateQuestionCommand {
    @NotNull(message = "Organization ID is required")
    private final UUID organizationId;

    @NotNull(message = "Created by is required")
    private final UUID createdBy;

    @NotNull(message = "Updated by is required")
    private final UUID updatedBy;

    @NotNull(message = "Difficulty by is required")
    private final String difficulty;

    @NotNull(message = "Name is required")
    private final String name;

    @NotNull(message = "Question text is required")
    private final String questionText;

    @NotNull(message = "General feedback is required")
    private final String generalFeedback;

    @NotNull(message = "Default mark is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Default mark must be greater than 0")
    @Digits(integer = 5, fraction = 2, message = "Default mark must have up to 5 digits and 2 decimals")
    private final BigDecimal defaultMark;

    @NotNull(message = "Question type is required")
    private final String qType;

    @NotNull(message = "Answers is required")
    private List<AnswerOfQuestion> answers;

    private final UUID questionBankCategoryId;
    private final Boolean isOrgQuestionBank;
}
