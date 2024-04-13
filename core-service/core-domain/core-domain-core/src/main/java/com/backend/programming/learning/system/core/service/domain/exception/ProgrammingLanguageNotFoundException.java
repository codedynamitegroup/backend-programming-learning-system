package com.backend.programming.learning.system.core.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class ProgrammingLanguageNotFoundException extends DomainException {
    public ProgrammingLanguageNotFoundException(String message) {
        super(message);
    }

    public ProgrammingLanguageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
