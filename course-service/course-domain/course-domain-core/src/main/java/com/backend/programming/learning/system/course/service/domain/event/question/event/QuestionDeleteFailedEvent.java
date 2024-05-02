package com.backend.programming.learning.system.course.service.domain.event.question.event;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.course.service.domain.entity.Question;

import java.time.ZonedDateTime;

public class QuestionDeleteFailedEvent extends QuestionEvent{
    public QuestionDeleteFailedEvent(
            Question question,
            ZonedDateTime createdAt,
            CopyState copyState, String sagaId) {
        super(question, createdAt, copyState, sagaId);
    }

    @Override
    public void fire() {

    }
}
