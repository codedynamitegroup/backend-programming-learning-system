package com.backend.programming.learning.system.auth.service.domain.event.organization;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class OrganizationUpdatedEvent extends OrganizationEvent {
    private final DomainEventPublisher<OrganizationUpdatedEvent> organizationUpdatedEventDomainEventPublisher;
    public OrganizationUpdatedEvent(Organization organization, ZonedDateTime createdAt, DomainEventPublisher<OrganizationUpdatedEvent> organizationUpdatedEventDomainEventPublisher) {
        super(organization, createdAt);
        this.organizationUpdatedEventDomainEventPublisher = organizationUpdatedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        organizationUpdatedEventDomainEventPublisher.publish(this);
    }
}
