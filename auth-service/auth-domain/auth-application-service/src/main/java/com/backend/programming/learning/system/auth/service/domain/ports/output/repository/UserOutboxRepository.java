package com.backend.programming.learning.system.auth.service.domain.ports.output.repository;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.domain.valueobject.UserOutboxServiceType;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserOutboxRepository {
    UserOutboxMessage save(UserOutboxMessage userOutboxMessage);

    Optional<List<UserOutboxMessage>> findByTypeAndOutboxStatusAndSagaStatus(String type,
                                                                                              OutboxStatus outboxStatus,
                                                                                              SagaStatus... sagaStatus);
    void deleteByTypeAndOutboxStatusAndSagaStatus(String type,
                                                  OutboxStatus outboxStatus,
                                                  SagaStatus... sagaStatus);

    Optional<UserOutboxMessage> findByTypeAndSagaIdAndSagaStatusAndServiceName(String sagaType,
                                                                                                         UUID sagaId,
                                                                                                         SagaStatus sagaStatus,
                                                                                                         ServiceName serviceName);

    Optional<UserOutboxMessage> findByTypeAndSagaIdAndCopyStateAndServiceName(String type,
                                                                                                     UUID sagaId,
                                                                                                     CopyState copyState,
                                                                                                     ServiceName serviceName);
}
