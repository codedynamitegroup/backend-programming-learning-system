package com.backend.programming.learning.system.course.service.domain.event.organization;

import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.List;

public class OrganizationUpdatedFailEvent extends OrganizationEvent {
    private final DomainEventPublisher<OrganizationUpdatedFailEvent> organizationUpdatedFailEventDomainEventPublisher;
    public OrganizationUpdatedFailEvent(Organization organization,
                                        ZonedDateTime createdAt,
                                        DomainEventPublisher<OrganizationUpdatedFailEvent> organizationUpdatedFailEventDomainEventPublisher,
                                        List<String> failureMessages) {
        super(organization, createdAt, failureMessages);
        this.organizationUpdatedFailEventDomainEventPublisher = organizationUpdatedFailEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        organizationUpdatedFailEventDomainEventPublisher.publish(this);
    }
}
