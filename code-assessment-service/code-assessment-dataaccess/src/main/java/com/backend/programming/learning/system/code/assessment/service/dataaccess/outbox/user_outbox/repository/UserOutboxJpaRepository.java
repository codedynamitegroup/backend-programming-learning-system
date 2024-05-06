package com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.user_outbox.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.user_outbox.entity.UserOutboxEntity;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserOutboxJpaRepository extends JpaRepository<UserOutboxEntity, UUID> {

    Optional<List<UserOutboxEntity>> findByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);

    Optional<UserOutboxEntity> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String type,
                                                                              UUID sagaId,
                                                                              CopyState copyState,
                                                                              OutboxStatus outboxStatus);

    void deleteByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);

}
