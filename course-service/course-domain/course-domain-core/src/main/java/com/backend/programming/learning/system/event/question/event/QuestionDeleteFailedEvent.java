package com.backend.programming.learning.system.event.question.event;

import com.backend.programming.learning.system.domain.valueobject.QuestionResponseStatus;
import com.backend.programming.learning.system.entity.Question;

import java.time.ZonedDateTime;

public class QuestionDeleteFailedEvent extends QuestionEvent{
    public QuestionDeleteFailedEvent(
            Question question,
            ZonedDateTime createdAt,
            QuestionResponseStatus status) {
        super(question, createdAt, status);
    }

    @Override
    public void fire() {

    }
}
