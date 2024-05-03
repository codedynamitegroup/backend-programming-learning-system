package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizationOutboxRepository {
    OrganizationOutboxMessage save(OrganizationOutboxMessage userOutboxMessage);

    Optional<List<OrganizationOutboxMessage>> findByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);
    Optional<OrganizationOutboxMessage> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String type,
                                                                 UUID sagaId,
                                                                 CopyState copyState,
                                                                 OutboxStatus outboxStatus);
    void deleteByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);
}
