package com.backend.programming.learning.system.domain.exception;

public class TopicDomainException extends DomainException {
    public TopicDomainException(String message) {
        super(message);
    }

    public TopicDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
