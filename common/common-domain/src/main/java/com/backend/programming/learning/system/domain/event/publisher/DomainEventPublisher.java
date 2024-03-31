package com.backend.programming.learning.system.domain.event.publisher;

import com.backend.programming.learning.system.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
