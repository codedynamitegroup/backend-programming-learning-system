package com.backend.programming.learning.system.core.service.domain.event.question.event;

import com.backend.programming.learning.system.core.service.domain.entity.*;

import java.time.ZonedDateTime;
import java.util.UUID;

public class QuestionUpdatedEvent extends QuestionEvent {
    private final Question prevQuestion;
    private final QtypeCodeQuestion qtypeCodeQuestion;
    private final QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion;
    private final QtypeEssayQuestion qtypeEssayQuestion;
    private final QtypeShortAnswerQuestion qtypeShortAnswerQuestion;

    public QuestionUpdatedEvent(
            Question question,
            UUID qtypeID,
            ZonedDateTime createdAt,
            Question prevQuestion,
            QtypeCodeQuestion qtypeCodeQuestion,
            QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion,
            QtypeEssayQuestion qtypeEssayQuestion,
            QtypeShortAnswerQuestion qtypeShortAnswerQuestion) {
        super(question, qtypeID, createdAt);
        this.prevQuestion = prevQuestion;
        this.qtypeCodeQuestion = qtypeCodeQuestion;
        this.qtypeMultiChoiceQuestion = qtypeMultiChoiceQuestion;
        this.qtypeEssayQuestion = qtypeEssayQuestion;
        this.qtypeShortAnswerQuestion = qtypeShortAnswerQuestion;
    }

    public Question getPrevQuestion() {
        return prevQuestion;
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
