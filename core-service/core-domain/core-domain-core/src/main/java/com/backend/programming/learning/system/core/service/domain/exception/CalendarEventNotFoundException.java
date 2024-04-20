package com.backend.programming.learning.system.core.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CalendarEventNotFoundException extends DomainException {
    public CalendarEventNotFoundException(String message) {
        super(message);
    }

    public CalendarEventNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
