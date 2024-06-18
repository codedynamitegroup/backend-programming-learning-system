package com.backend.programming.learning.system.core.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class ChapterResourceNotFoundException extends DomainException {
    public ChapterResourceNotFoundException(String message) {
        super(message);
    }

    public ChapterResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
