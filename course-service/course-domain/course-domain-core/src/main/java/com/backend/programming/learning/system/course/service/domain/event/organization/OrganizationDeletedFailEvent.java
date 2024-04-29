package com.backend.programming.learning.system.course.service.domain.event.organization;

import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.List;

public class OrganizationDeletedFailEvent extends OrganizationEvent {
    private final DomainEventPublisher<OrganizationDeletedFailEvent> organizationDeletedFailEventDomainEventPublisher;
    public OrganizationDeletedFailEvent(Organization organization,
                                        ZonedDateTime createdAt,
                                        DomainEventPublisher<OrganizationDeletedFailEvent> organizationDeletedFailEventDomainEventPublisher,
                                        List<String> failureMessages) {
        super(organization, createdAt, failureMessages);
        this.organizationDeletedFailEventDomainEventPublisher = organizationDeletedFailEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        organizationDeletedFailEventDomainEventPublisher.publish(this);
    }
}
