package com.backend.programming.learning.system.code.assessment.service.domain.exeption.tag;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class TagNotFoundException extends DomainException {
    public TagNotFoundException(String message) {
        super(message);
    }

    public TagNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}