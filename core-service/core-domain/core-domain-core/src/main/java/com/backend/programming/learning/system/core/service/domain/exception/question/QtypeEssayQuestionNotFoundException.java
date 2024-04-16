package com.backend.programming.learning.system.core.service.domain.exception.question;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class QtypeEssayQuestionNotFoundException extends DomainException {
    public QtypeEssayQuestionNotFoundException(String message) {
        super(message);
    }

    public QtypeEssayQuestionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
