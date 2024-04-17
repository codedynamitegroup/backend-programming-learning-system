package com.backend.programming.learning.system.core.service.domain.event.question.event;

import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;
import java.util.UUID;

public abstract class QuestionEvent implements DomainEvent<Question> {
    private final Question question;
    private final UUID qtypeID;
    private final ZonedDateTime createdAt;

    public QuestionEvent(Question question, UUID qtypeID, ZonedDateTime createdAt) {
        this.question = question;
        this.createdAt = createdAt;
        this.qtypeID = qtypeID;
    }

    public Question getQuestion() {
        return question;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public UUID getQtypeID() {
        return qtypeID;
    }
}
