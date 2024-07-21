package com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_sender_outbox.repository;

import com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_sender_outbox.entity.CodeSubmissionSenderOutboxEntity;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeSubmissionSenderOutboxJpaRepository extends JpaRepository<CodeSubmissionSenderOutboxEntity, UUID> {
    Optional<List<CodeSubmissionSenderOutboxEntity>> findByOutboxStatus(OutboxStatus outboxStatus);

    void deleteByOutboxStatus(OutboxStatus outboxStatus);
}
