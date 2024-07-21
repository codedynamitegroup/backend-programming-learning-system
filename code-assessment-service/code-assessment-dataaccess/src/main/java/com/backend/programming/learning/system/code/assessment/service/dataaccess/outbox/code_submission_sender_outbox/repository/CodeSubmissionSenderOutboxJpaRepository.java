package com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_sender_outbox.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_sender_outbox.entity.CodeSubmissionSenderOutboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeSubmissionSenderOutboxJpaRepository extends JpaRepository<CodeSubmissionSenderOutboxEntity, UUID> {
    Optional<CodeSubmissionSenderOutboxEntity> findBySagaId(UUID sagaId);
}
