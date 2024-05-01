package com.backend.programming.learning.system.core.service.dataaccess.outbox.question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.outbox.question.entity.QuestionOutboxEntity;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionOutboxJpaRepository extends JpaRepository<QuestionOutboxEntity, UUID> {
    Optional<List<QuestionOutboxEntity>> findByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                                                      OutboxStatus outboxStatus,
                                                                                      List<SagaStatus> sagaStatus);
    Optional<QuestionOutboxEntity> findByTypeAndSagaIdAndSagaStatusIn(String type,
                                                                          UUID sagaId,
                                                                          List<SagaStatus> sagaStatus);
    void deleteByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                    OutboxStatus outboxStatus,
                                                    List<SagaStatus> sagaStatus);
}
