package com.backend.programming.learning.system.course.service.domain.event.organization;

import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.Collections;

public class OrganizationUpdatedSuccessEvent extends OrganizationEvent {
    private final DomainEventPublisher<OrganizationUpdatedSuccessEvent> organizationUpdatedSuccessEventDomainEventPublisher;
    public OrganizationUpdatedSuccessEvent(Organization organization,
                                           ZonedDateTime createdAt,
                                           DomainEventPublisher<OrganizationUpdatedSuccessEvent> organizationUpdatedSuccessEventDomainEventPublisher) {
        super(organization, createdAt, Collections.emptyList());
        this.organizationUpdatedSuccessEventDomainEventPublisher = organizationUpdatedSuccessEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        organizationUpdatedSuccessEventDomainEventPublisher.publish(this);
    }
}
