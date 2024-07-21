package com.backend.programming.learning.system.course.service.domain.ports.output.repository.outbox;

import java.util.Optional;
import java.util.UUID;

public interface CodeSubmissionResultOutboxRepository {
    void save(UUID id, UUID sagaId);
    Optional<UUID> findBySagaId(UUID sagaId);
}
