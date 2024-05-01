package com.backend.programming.learning.system.course.service.domain.event.organization;

import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.Collections;

public class OrganizationCreatedSuccessEvent extends OrganizationEvent {
    private final DomainEventPublisher<OrganizationCreatedSuccessEvent> organizationCreatedSuccessEventDomainEventPublisher;
    public OrganizationCreatedSuccessEvent(Organization organization,
                                           ZonedDateTime createdAt,
                                           DomainEventPublisher<OrganizationCreatedSuccessEvent> organizationCreatedSuccessEventDomainEventPublisher ) {
        super(organization, createdAt, Collections.emptyList());
       this.organizationCreatedSuccessEventDomainEventPublisher = organizationCreatedSuccessEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        organizationCreatedSuccessEventDomainEventPublisher.publish(this);
    }
}
