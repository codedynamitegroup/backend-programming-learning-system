package com.backend.programming.learning.system.auth.service.domain.event.organization;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class OrganizationCreatedEvent extends OrganizationEvent {
    public OrganizationCreatedEvent(Organization organization, ZonedDateTime createdAt) {
        super(organization, createdAt);
    }

    @Override
    public void fire() {

    }
}
