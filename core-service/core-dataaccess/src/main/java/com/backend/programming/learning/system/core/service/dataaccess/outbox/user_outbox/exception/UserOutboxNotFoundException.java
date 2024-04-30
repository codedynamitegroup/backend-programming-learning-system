package com.backend.programming.learning.system.core.service.dataaccess.outbox.user_outbox.exception;

public class UserOutboxNotFoundException extends RuntimeException {

    public UserOutboxNotFoundException(String message) {
        super(message);
    }
}
