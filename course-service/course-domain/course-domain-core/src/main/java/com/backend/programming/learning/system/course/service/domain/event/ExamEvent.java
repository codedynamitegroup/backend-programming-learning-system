package com.backend.programming.learning.system.course.service.domain.event;

import com.backend.programming.learning.system.domain.event.DomainEvent;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;

import java.time.ZonedDateTime;

public abstract class ExamEvent implements DomainEvent<Exam> {
    private final Exam exam;
    private final ZonedDateTime createdAt;

    public ExamEvent(Exam exam,ZonedDateTime createdAt) {
        this.exam = exam;
        this.createdAt = createdAt;
    }

    public Exam getExam() {
        return exam;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
