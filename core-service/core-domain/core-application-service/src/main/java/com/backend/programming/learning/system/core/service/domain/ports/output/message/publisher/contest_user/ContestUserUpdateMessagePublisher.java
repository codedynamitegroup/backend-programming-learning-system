package com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.contest_user;

import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserUpdateOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface ContestUserUpdateMessagePublisher {
    void publish(ContestUserUpdateOutboxMessage contestUserUpdateOutboxMessage,
                 BiConsumer<ContestUserUpdateOutboxMessage, OutboxStatus> outboxCallback);
}
