package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserOutboxRepository {
    UserOutboxMessage save(UserOutboxMessage userOutboxMessage);

    Optional<List<UserOutboxMessage>> findByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);
    Optional<UserOutboxMessage> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String type,
                                                                 UUID sagaId,
                                                                 CopyState copyState,
                                                                 OutboxStatus outboxStatus);
    void deleteByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);
}
