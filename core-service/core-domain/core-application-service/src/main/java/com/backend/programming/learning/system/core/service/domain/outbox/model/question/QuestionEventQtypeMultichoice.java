package com.backend.programming.learning.system.core.service.domain.outbox.model.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class QuestionEventQtypeMultichoice {
    private String id;
    private String questionId;
    private final Boolean single;
    private final Boolean shuffleAnswers;
    private final String correctFeedback;
    private final String partiallyCorrectFeedback;
    private final String incorrectFeedback;
    private final String answerNumbering;
    private final Integer showNumCorrect;
    private final String showStandardInstructions;
}
