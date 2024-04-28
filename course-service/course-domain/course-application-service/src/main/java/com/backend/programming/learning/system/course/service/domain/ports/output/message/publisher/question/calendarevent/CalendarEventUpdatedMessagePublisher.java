package com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.calendarevent;

import com.backend.programming.learning.system.course.service.domain.event.calendarevent.CalendarEventUpdatedEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface CalendarEventUpdatedMessagePublisher extends DomainEventPublisher<CalendarEventUpdatedEvent> {
}
