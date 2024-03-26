package com.backend.programming.learning.system.course.service.domain.event;

import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.event.DomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.domain.event
 * Create by Dang Ngoc Tien
 * Date 3/24/2024 - 3:00 PM
 * Description: ...
 */
@Getter
public class ExamCreateEvent implements DomainEvent<Exam> {
    private final Exam exam;
    private final LocalDateTime createAt;

    public ExamCreateEvent(Exam exam, LocalDateTime createAt) {
        this.exam = exam;
        this.createAt = LocalDateTime.now();
    }
}
