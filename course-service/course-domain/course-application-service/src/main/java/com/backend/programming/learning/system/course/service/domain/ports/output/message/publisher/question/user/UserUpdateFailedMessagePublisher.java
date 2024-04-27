package com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.user;

import com.backend.programming.learning.system.course.service.domain.event.user.UserUpdatedFailEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface UserUpdateFailedMessagePublisher extends DomainEventPublisher<UserUpdatedFailEvent> {
}
