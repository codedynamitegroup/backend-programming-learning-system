package com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.organization;

import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserUpdatedEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface OrganizationUpdatedMessagePublisher extends DomainEventPublisher<OrganizationUpdatedEvent> {
}
