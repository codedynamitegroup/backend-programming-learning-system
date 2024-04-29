package com.backend.programming.learning.system.auth.service.dataaccess.outbox.organization.exception;

public class OrganizationOutboxNotFoundException extends RuntimeException {

    public OrganizationOutboxNotFoundException(String message) {
        super(message);
    }
}
