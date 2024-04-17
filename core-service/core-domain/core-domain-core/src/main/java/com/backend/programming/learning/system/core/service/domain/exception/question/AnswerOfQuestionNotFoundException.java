package com.backend.programming.learning.system.core.service.domain.exception.question;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class AnswerOfQuestionNotFoundException extends DomainException {
    public AnswerOfQuestionNotFoundException(String message) {
        super(message);
    }

    public AnswerOfQuestionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
