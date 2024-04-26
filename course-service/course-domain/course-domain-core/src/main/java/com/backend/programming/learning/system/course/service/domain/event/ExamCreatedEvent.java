package com.backend.programming.learning.system.course.service.domain.event;

import com.backend.programming.learning.system.course.service.domain.entity.Exam;

import java.time.ZonedDateTime;

public class ExamCreatedEvent extends ExamEvent{
    public ExamCreatedEvent(Exam exam, ZonedDateTime createdAt) {
        super(exam, createdAt);
    }

    @Override
    public void fire() {

    }
}
