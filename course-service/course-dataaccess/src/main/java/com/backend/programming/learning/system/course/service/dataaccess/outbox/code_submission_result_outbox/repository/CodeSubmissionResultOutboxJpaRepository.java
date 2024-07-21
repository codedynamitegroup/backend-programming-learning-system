package com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_result_outbox.repository;

import com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_result_outbox.entity.CodeSubmissionResultOutboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeSubmissionResultOutboxJpaRepository extends JpaRepository<CodeSubmissionResultOutboxEntity, UUID> {
    Optional<CodeSubmissionResultOutboxEntity> findBySagaId(UUID sagaId);
}
