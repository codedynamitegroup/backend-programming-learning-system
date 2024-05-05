package com.backend.programming.learning.system.auth.service.domain.ports.output.repository;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizationOutboxRepository {
    OrganizationOutboxMessage save(OrganizationOutboxMessage organizationOutboxMessage);

    Optional<List<OrganizationOutboxMessage>> findByTypeAndOutboxStatusAndSagaStatus(String type,
                                                                                      OutboxStatus outboxStatus,
                                                                                      SagaStatus... sagaStatus);
    Optional<OrganizationOutboxMessage> findByTypeAndSagaIdAndServiceNameAndSagaStatus(String type,
                                                                          UUID sagaId,
                                                                          ServiceName serviceName,
                                                                          SagaStatus... sagaStatus);
    void deleteByTypeAndOutboxStatusAndSagaStatus(String type,
                                                  OutboxStatus outboxStatus,
                                                  SagaStatus... sagaStatus);
}
