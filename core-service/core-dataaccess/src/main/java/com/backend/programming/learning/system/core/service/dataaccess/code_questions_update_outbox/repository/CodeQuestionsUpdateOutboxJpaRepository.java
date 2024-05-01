package com.backend.programming.learning.system.core.service.dataaccess.code_questions_update_outbox.repository;

import com.backend.programming.learning.system.core.service.dataaccess.code_questions_update_outbox.entity.CodeQuestionsUpdateOutboxEntity;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeQuestionsUpdateOutboxJpaRepository extends
        JpaRepository<CodeQuestionsUpdateOutboxEntity, UUID> {
    Optional<List<CodeQuestionsUpdateOutboxEntity>> findByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);

    Optional<CodeQuestionsUpdateOutboxEntity> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String type,
                                                                                   UUID sagaId,
                                                                                   CopyState copyState,
                                                                                   OutboxStatus outboxStatus);

    void deleteByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);
}
