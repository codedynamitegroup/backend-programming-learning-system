package com.backend.programming.learning.system.auth.service.domain.event.organization;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class OrganizationDeletedEvent extends OrganizationEvent {
    private final DomainEventPublisher<OrganizationDeletedEvent> organizationDeletedEventDomainEventPublisher;
    public OrganizationDeletedEvent(Organization organization, ZonedDateTime createdAt, DomainEventPublisher<OrganizationDeletedEvent> organizationDeletedEventDomainEventPublisher) {
        super(organization, createdAt);
        this.organizationDeletedEventDomainEventPublisher = organizationDeletedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        organizationDeletedEventDomainEventPublisher.publish(this);
    }
}
