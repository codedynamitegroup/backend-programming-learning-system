package com.backend.programming.learning.system.core.service.domain.dto.method.update.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateQtypeMultichoiceQuestionCommand {
    @NotNull(message = "Qtype Question ID is required")
    private final UUID qtMultichoiceQuestionId;

    @NotNull(message = "Question object is required")
    private final UpdateQuestionEntity question;

    private final Boolean single;
    private final Boolean shuffleAnswers;
    private final String correctFeedback;
    private final String partiallyCorrectFeedback;
    private final String incorrectFeedback;
    private final String answerNumbering;
    private final Integer showNumCorrect;
    private final String showStandardInstructions;
}
