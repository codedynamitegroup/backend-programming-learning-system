package com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.organization;

import com.backend.programming.learning.system.course.service.domain.event.organization.OrganizationUpdatedSuccessEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface OrganizationUpdatedSuccessMessagePublisher extends DomainEventPublisher<OrganizationUpdatedSuccessEvent> {
}
