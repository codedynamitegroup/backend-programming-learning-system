package com.backend.programming.learning.system.course.service.dataaccess.outbox.question.exception;

public class QuestionOutboxNotFoundException extends RuntimeException{
    public QuestionOutboxNotFoundException(String message) {
        super(message);
    }
}
