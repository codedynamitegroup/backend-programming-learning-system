package com.backend.programming.learning.system.core.service.domain.event.question.event;

import com.backend.programming.learning.system.core.service.domain.entity.Question;

import java.time.ZonedDateTime;
import java.util.UUID;

public class QuestionCreatedEvent extends QuestionEvent {
    public QuestionCreatedEvent(Question question, UUID qtypeId, ZonedDateTime createdAt) {
        super(question, qtypeId, createdAt);
    }

    @Override
    public void fire() {

    }
}
