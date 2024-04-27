package com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.calendarevent;

import com.backend.programming.learning.system.core.service.domain.event.calendarevent.CalendarEventCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.user.UserCreatedSuccessEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface CalendarEventCreatedMessagePublisher extends DomainEventPublisher<CalendarEventCreatedEvent> {
}
