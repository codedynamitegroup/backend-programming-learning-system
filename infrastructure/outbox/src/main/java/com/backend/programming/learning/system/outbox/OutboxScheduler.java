package com.backend.programming.learning.system.outbox;

public interface OutboxScheduler {
    void processOutboxMessage();
}
