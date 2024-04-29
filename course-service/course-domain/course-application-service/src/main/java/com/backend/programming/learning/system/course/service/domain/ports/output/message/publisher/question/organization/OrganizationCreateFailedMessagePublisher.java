package com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.organization;

import com.backend.programming.learning.system.course.service.domain.event.organization.OrganizationCreatedFailEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface OrganizationCreateFailedMessagePublisher extends DomainEventPublisher<OrganizationCreatedFailEvent> {
}
