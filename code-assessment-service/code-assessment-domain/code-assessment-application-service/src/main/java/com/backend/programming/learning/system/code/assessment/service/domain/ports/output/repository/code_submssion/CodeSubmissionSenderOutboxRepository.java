package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion;

import java.util.Optional;
import java.util.UUID;

public interface CodeSubmissionSenderOutboxRepository {
    void save(UUID id, UUID sagaId);
    Optional<UUID> findBySagaId(UUID sagaId);
}
