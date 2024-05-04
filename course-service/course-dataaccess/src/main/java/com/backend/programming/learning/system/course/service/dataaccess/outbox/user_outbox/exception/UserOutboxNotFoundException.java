package com.backend.programming.learning.system.course.service.dataaccess.outbox.user_outbox.exception;

public class UserOutboxNotFoundException extends RuntimeException {

    public UserOutboxNotFoundException(String message) {
        super(message);
    }
}
