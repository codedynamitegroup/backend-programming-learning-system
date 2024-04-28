package com.backend.programming.learning.system.course.service.domain.event.organization;

import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.Collections;

public class OrganizationDeletedSuccessEvent extends OrganizationEvent {
    private final DomainEventPublisher<OrganizationDeletedSuccessEvent> organizationDeletedSuccessEventDomainEventPublisher;
    public OrganizationDeletedSuccessEvent(Organization organization,
                                           ZonedDateTime createdAt,
                                           DomainEventPublisher<OrganizationDeletedSuccessEvent> organizationDeletedSuccessEventDomainEventPublisher) {
        super(organization, createdAt, Collections.emptyList());
        this.organizationDeletedSuccessEventDomainEventPublisher = organizationDeletedSuccessEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        organizationDeletedSuccessEventDomainEventPublisher.publish(this);
    }
}
