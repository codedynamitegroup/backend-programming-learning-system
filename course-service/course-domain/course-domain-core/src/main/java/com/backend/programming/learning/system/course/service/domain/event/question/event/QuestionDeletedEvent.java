package com.backend.programming.learning.system.course.service.domain.event.question.event;

import com.backend.programming.learning.system.domain.valueobject.QuestionResponseStatus;
import com.backend.programming.learning.system.course.service.domain.entity.Question;

import java.time.ZonedDateTime;

public class QuestionDeletedEvent extends QuestionEvent{
    public QuestionDeletedEvent(
            Question question,
            ZonedDateTime createdAt, QuestionResponseStatus status) {
        super(question, createdAt, status);
    }

    @Override
    public void fire() {

    }
}
