package com.backend.programming.learning.system.core.service.dataaccess.outbox.question.exception;

public class QuestionOutboxNotFoundException  extends RuntimeException {
    public QuestionOutboxNotFoundException(String message) {
        super(message);
    }
}
