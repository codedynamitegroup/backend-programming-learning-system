package com.backend.programming.learning.system.core.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
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
    private final String difficulty;
    @NotNull(message = "Name is required")
    private final String name;
    @NotNull(message = "Question text is required")
    private final String questionText;
    @NotNull(message = "General feedback is required")
    private final String generalFeedback;
    @NotNull(message = "Default mark is required")
    private final BigDecimal defaultMark;
    @NotNull(message = "Question type is required")
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
