package com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.organization;

import com.backend.programming.learning.system.course.service.domain.event.organization.OrganizationUpdatedFailEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface OrganizationUpdateFailedMessagePublisher extends DomainEventPublisher<OrganizationUpdatedFailEvent> {
}