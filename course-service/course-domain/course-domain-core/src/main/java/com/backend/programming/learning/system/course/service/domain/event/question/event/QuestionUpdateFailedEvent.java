package com.backend.programming.learning.system.course.service.domain.event.question.event;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.course.service.domain.entity.Question;

import java.time.ZonedDateTime;

public class QuestionUpdateFailedEvent extends QuestionEvent{
    public QuestionUpdateFailedEvent(
            Question question,
            ZonedDateTime createdAt,
            CopyState copyState) {
        super(question, createdAt, copyState);
    }

    @Override
    public void fire() {

    }
}
