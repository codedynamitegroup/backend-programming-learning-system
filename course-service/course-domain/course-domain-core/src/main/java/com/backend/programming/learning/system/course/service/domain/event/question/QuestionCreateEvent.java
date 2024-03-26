package com.backend.programming.learning.system.course.service.domain.event.question;

import com.backend.programming.learning.system.course.service.domain.entity.question.Question;
import com.backend.programming.learning.system.event.DomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.domain.event.question
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:47 PM
 * Description: ...
 */
@Getter
public class QuestionCreateEvent implements DomainEvent<Question> {
    private final Question question;
    private final LocalDateTime createAt;
    public QuestionCreateEvent(Question question, LocalDateTime createAt) {
        this.question = question;
        this.createAt = LocalDateTime.now();
    }
}
