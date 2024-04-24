package com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.organization;

import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserDeletedEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface OrganizationDeletedMessagePublisher extends DomainEventPublisher<OrganizationDeletedEvent> {
}
