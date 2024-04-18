package com.backend.programming.learning.system.core.service.domain.event.question.event;

import com.backend.programming.learning.system.core.service.domain.entity.Question;

import java.time.ZonedDateTime;
import java.util.UUID;

public class QuestionUpdatedEvent extends QuestionEvent{
    public QuestionUpdatedEvent(
            Question question,
            UUID qtypeID,
            ZonedDateTime createdAt) {
        super(question, qtypeID, createdAt);
    }

    @Override
    public void fire() {

    }
}
