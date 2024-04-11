package com.backend.programming.learning.system.domain.event.Question;

import com.backend.programming.learning.system.domain.entity.Question;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;

public abstract class QuestionEvent implements DomainEvent<Question> {
    private final Question question;
    private final ZonedDateTime createdAt;

    public QuestionEvent(Question question, ZonedDateTime createdAt) {
        this.question = question;
        this.createdAt = createdAt;
    }

    public Question getQuestion() {
        return question;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
