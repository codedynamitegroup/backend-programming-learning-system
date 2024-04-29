package com.backend.programming.learning.system.saga;

import com.backend.programming.learning.system.domain.event.DomainEvent;

public interface SagaStepApplyOutboxPattern<T> {
    void process(T data);
    void rollback(T data);
}
