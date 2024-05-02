package com.backend.programming.learning.system.course.service.domain.event.question.event;

import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.domain.valueobject.CopyState;

import java.time.ZonedDateTime;

public class QuestionDeletedEvent extends QuestionEvent{
    public QuestionDeletedEvent(
            Question question,
            ZonedDateTime createdAt, CopyState copyState, String sagaId) {
        super(question, createdAt, copyState, sagaId);
    }

    @Override
    public void fire() {

    }
}
