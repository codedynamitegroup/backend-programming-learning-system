package com.backend.programming.learning.system.core.service.domain.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class CreateQuestionCommand {
    @NotNull
    private final UUID organizationId;
    @NotNull
    private final UUID createdBy;
    @NotNull
    private final UUID updatedBy;
    @NotNull
    private final String difficulty;
    @NotNull
    private final String name;
    @NotNull
    private final String questionText;
    @NotNull
    private final String generalFeedback;
    @NotNull
    private final BigDecimal defaultMark;
    @NotNull
    private final String qType;

    // for code question
    private final String dslTemplate;

    // for short answer question
    private final Boolean caseSensitive;

    // for multiple choice question
    private final Integer single;
    private final Integer shuffleAnswers;
    private final String correctFeedback;
    private final String partiallyCorrectFeedback;
    private final String incorrectFeedback;
    private final String answerNumbering;
    private final Integer showNumCorrect;
    private final String showStandardInstructions;

    // for essay question
    private final String responseFormat;
    private final Integer responseRequired;
    private final Integer responseFieldLines;
    private final Integer minWordLimit;
    private final Integer maxWordLimit;
    private final Integer attachments;
    private final Integer attachmentsRequired;
    private final String graderInfo;
    private final Integer graderInfoFormat;
    private final String responseTemplate;
    private final Integer maxBytes;
    private final String fileTypesList;
}
