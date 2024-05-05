package com.backend.programming.learning.system.core.service.domain.event.question.event;

import com.backend.programming.learning.system.core.service.domain.entity.*;

import java.time.ZonedDateTime;
import java.util.UUID;

public class QuestionDeletedEvent extends QuestionEvent{
    private final QtypeCodeQuestion qtypeCodeQuestion;
    private final QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion;
    private final QtypeEssayQuestion qtypeEssayQuestion;
    private final QtypeShortAnswerQuestion qtypeShortAnswerQuestion;

    public QuestionDeletedEvent(
            Question question,
            UUID qtypeID,
            ZonedDateTime createdAt,
            QtypeCodeQuestion qtypeCodeQuestion,
            QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion,
            QtypeEssayQuestion qtypeEssayQuestion,
            QtypeShortAnswerQuestion qtypeShortAnswerQuestion) {
        super(question, qtypeID, createdAt);
        this.qtypeCodeQuestion = qtypeCodeQuestion;
        this.qtypeMultiChoiceQuestion = qtypeMultiChoiceQuestion;
        this.qtypeEssayQuestion = qtypeEssayQuestion;
        this.qtypeShortAnswerQuestion = qtypeShortAnswerQuestion;
    }

    public QtypeCodeQuestion getQtypeCodeQuestion() {
        return qtypeCodeQuestion;
    }

    public QtypeMultiChoiceQuestion getQtypeMultiChoiceQuestion() {
        return qtypeMultiChoiceQuestion;
    }

    public QtypeEssayQuestion getQtypeEssayQuestion() {
        return qtypeEssayQuestion;
    }

    public QtypeShortAnswerQuestion getQtypeShortAnswerQuestion() {
        return qtypeShortAnswerQuestion;
    }

    @Override
    public void fire() {

    }
}
