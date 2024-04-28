package com.backend.programming.learning.system.course.service.domain.event.organization;

import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;
import java.util.List;

public abstract class OrganizationEvent implements DomainEvent<Organization> {
    private final Organization organization;
    private final ZonedDateTime createdAt;
    private final List<String> failureMessages;

    protected OrganizationEvent(Organization organization, ZonedDateTime createdAt, List<String> failureMessages) {
        this.organization = organization;
        this.createdAt = createdAt;
        this.failureMessages = failureMessages;
    }

    public Organization getOrganization() {
        return organization;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }
}
