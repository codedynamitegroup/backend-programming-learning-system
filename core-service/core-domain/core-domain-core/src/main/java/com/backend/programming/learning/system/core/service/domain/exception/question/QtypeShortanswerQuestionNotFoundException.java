package com.backend.programming.learning.system.core.service.domain.exception.question;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class QtypeShortanswerQuestionNotFoundException extends DomainException {
    public QtypeShortanswerQuestionNotFoundException(String message) {
        super(message);
    }

    public QtypeShortanswerQuestionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
