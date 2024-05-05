package com.backend.programming.learning.system.core.service.dataaccess.outbox.organization_outbox.repository;

import com.backend.programming.learning.system.core.service.dataaccess.outbox.organization_outbox.entity.OrganizationOutboxEntity;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrganizationOutboxJpaRepository extends JpaRepository<OrganizationOutboxEntity, UUID> {

    Optional<List<OrganizationOutboxEntity>> findByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);

    Optional<OrganizationOutboxEntity> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String type,
                                                                                      UUID sagaId,
                                                                                      CopyState copyState,
                                                                                      OutboxStatus outboxStatus);

    void deleteByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);

}
