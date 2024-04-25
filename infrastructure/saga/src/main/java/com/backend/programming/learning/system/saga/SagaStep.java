package com.backend.programming.learning.system.saga;

import com.backend.programming.learning.system.domain.event.DomainEvent;

public interface SagaStep<T> {
    void process(T data);
    void rollback(T data);
}
