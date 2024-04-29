package com.backend.programming.learning.system.core.service.dataaccess.outbox.contest_user_update_outbox.repository;

import com.backend.programming.learning.system.core.service.dataaccess.outbox.contest_user_update_outbox.entity.ContestUserUpdateOutboxEntity;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContestUserUpdateOutboxJpaRepository extends JpaRepository<ContestUserUpdateOutboxEntity, UUID> {
    Optional<List<ContestUserUpdateOutboxEntity>> findByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                                                 OutboxStatus outboxStatus,
                                                                                 List<SagaStatus> sagaStatus);

    Optional<ContestUserUpdateOutboxEntity> findByTypeAndSagaIdAndSagaStatusIn(String type,
                                                                     UUID sagaId,
                                                                     List<SagaStatus> sagaStatus);

    void deleteByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                    OutboxStatus outboxStatus,
                                                    List<SagaStatus> sagaStatus);
}
