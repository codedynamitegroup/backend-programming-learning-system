package com.backend.programming.learning.system.course.service.domain.event.organization;

import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.List;

public class OrganizationCreatedFailEvent extends OrganizationEvent {
    private final DomainEventPublisher<OrganizationCreatedFailEvent> organizationCreatedFailEventDomainEventPublisher;
    public OrganizationCreatedFailEvent(Organization organization,
                                        ZonedDateTime createdAt,
                                        DomainEventPublisher<OrganizationCreatedFailEvent> organizationCreatedFailEventDomainEventPublisher,
                                        List<String>failureMessages) {
        super(organization, createdAt, failureMessages);
        this.organizationCreatedFailEventDomainEventPublisher = organizationCreatedFailEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        organizationCreatedFailEventDomainEventPublisher.publish(this);
    }
}
