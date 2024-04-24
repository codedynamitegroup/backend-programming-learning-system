package com.backend.programming.learning.system.auth.service.domain.event.organization;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;

public abstract class OrganizationEvent implements DomainEvent<Organization> {
    private final Organization organization;
    private final ZonedDateTime createdAt;

    protected OrganizationEvent(Organization organization, ZonedDateTime createdAt) {
        this.organization = organization;
        this.createdAt = createdAt;
    }

    public Organization getOrganization() {
        return organization;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
