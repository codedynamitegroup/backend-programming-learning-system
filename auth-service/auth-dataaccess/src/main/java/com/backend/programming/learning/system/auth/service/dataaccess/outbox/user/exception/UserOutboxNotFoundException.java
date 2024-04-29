package com.backend.programming.learning.system.auth.service.dataaccess.outbox.user.exception;

public class UserOutboxNotFoundException extends RuntimeException {

    public UserOutboxNotFoundException(String message) {
        super(message);
    }
}
