package com.backend.programming.learning.system.course.service.dataaccess.outbox.question.repository;

import com.backend.programming.learning.system.course.service.dataaccess.outbox.question.entity.QuestionOutboxEntity;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionOutboxJpaRepository extends JpaRepository<QuestionOutboxEntity, UUID> {
    Optional<List<QuestionOutboxEntity>> findByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);
    Optional<QuestionOutboxEntity> findByTypeAndSagaId(String type, UUID sagaId);
    void deleteByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);
}
