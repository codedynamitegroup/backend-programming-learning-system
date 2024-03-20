package com.backend.programming.learning.system.outbox;

/**
 * com.backend.programming.learning.system.outbox
 * Create by Dang Ngoc Tien
 * Date 3/20/2024 - 11:56 PM
 * Description: ...
 */
public interface OutboxScheduler {
    void processOutboxMessage();
}
