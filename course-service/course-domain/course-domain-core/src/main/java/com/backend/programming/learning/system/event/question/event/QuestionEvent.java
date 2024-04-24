package com.backend.programming.learning.system.event.question.event;

import com.backend.programming.learning.system.domain.event.DomainEvent;
import com.backend.programming.learning.system.domain.valueobject.QuestionResponseStatus;
import com.backend.programming.learning.system.entity.Question;

import java.time.ZonedDateTime;
import java.util.UUID;

public abstract class QuestionEvent implements DomainEvent<Question> {
    private final Question question;
    private final ZonedDateTime createdAt;
    private final QuestionResponseStatus status;

    public QuestionEvent(Question question, ZonedDateTime createdAt, QuestionResponseStatus status) {
        this.question = question;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Question getQuestion() {
        return question;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public QuestionResponseStatus getStatus() {
        return status;
    }
}
