package com.backend.programming.learning.system.event;

import com.backend.programming.learning.system.entity.Exam;

import java.time.ZonedDateTime;

public class ExamCreatedEvent extends ExamEvent{
    public ExamCreatedEvent(Exam exam, ZonedDateTime createdAt) {
        super(exam, createdAt);
    }

    @Override
    public void fire() {

    }
}
