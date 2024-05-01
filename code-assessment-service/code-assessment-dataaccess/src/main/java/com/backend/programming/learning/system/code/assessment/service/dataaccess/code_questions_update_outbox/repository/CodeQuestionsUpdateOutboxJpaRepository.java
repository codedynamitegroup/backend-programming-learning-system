package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_questions_update_outbox.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_questions_update_outbox.entity.CodeQuestionsUpdateOutboxEntity;
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
    Optional<List<CodeQuestionsUpdateOutboxEntity>> findByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                                                             OutboxStatus outboxStatus,
                                                                                             List<SagaStatus> sagaStatus);

    Optional<CodeQuestionsUpdateOutboxEntity> findByTypeAndSagaIdAndSagaStatusIn(String type,
                                                                     UUID sagaId,
                                                                     List<SagaStatus> sagaStatus);

    void deleteByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                    OutboxStatus outboxStatus,
                                                    List<SagaStatus> sagaStatus);
}
