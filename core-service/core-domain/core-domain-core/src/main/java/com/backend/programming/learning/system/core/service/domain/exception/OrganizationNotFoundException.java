package com.backend.programming.learning.system.core.service.domain.exception;

import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.exception.DomainException;

public class OrganizationNotFoundException extends DomainException {
    public OrganizationNotFoundException(String message) {
        super(message);
    }

    public OrganizationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
