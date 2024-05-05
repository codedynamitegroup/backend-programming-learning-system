package com.backend.programming.learning.system.auth.service.dataaccess.outbox.organization.repository;

import com.backend.programming.learning.system.auth.service.dataaccess.outbox.organization.entity.OrganizationOutboxEntity;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrganizationOutboxJpaRepository extends JpaRepository<OrganizationOutboxEntity, UUID> {

    Optional<List<OrganizationOutboxEntity>> findByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                                                      OutboxStatus outboxStatus,
                                                                                      List<SagaStatus> sagaStatus);

    Optional<OrganizationOutboxEntity> findByTypeAndSagaIdAndServiceNameAndSagaStatusIn(String type,
                                                                                UUID sagaId,
                                                                                ServiceName serviceName,
                                                                                List<SagaStatus> sagaStatus);

    void deleteByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                    OutboxStatus outboxStatus,
                                                    List<SagaStatus> sagaStatus);

}
