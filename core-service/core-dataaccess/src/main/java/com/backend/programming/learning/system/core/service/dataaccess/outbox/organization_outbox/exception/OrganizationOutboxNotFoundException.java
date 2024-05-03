package com.backend.programming.learning.system.core.service.dataaccess.outbox.organization_outbox.exception;

public class OrganizationOutboxNotFoundException extends RuntimeException {

    public OrganizationOutboxNotFoundException(String message) {
        super(message);
    }
}
