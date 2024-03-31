package com.backend.programming.learning.system.event;

import com.backend.programming.learning.system.domain.event.DomainEvent;
import com.backend.programming.learning.system.entity.Organization;

import java.time.ZonedDateTime;

public abstract class OrganizationEvent implements DomainEvent<Organization> {
    private final Organization organization;
    private final ZonedDateTime createdAt;

    protected OrganizationEvent(Organization organization, ZonedDateTime createdAt) {
        this.organization = organization;
        this.createdAt = createdAt;
    }

    public Organization organization() {
        return organization;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
