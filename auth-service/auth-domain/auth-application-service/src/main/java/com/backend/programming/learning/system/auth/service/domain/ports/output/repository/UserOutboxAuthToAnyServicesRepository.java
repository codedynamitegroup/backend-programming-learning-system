package com.backend.programming.learning.system.auth.service.domain.ports.output.repository;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_auth_to_any_services.UserOutboxAuthToAnyServicesMessage;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserOutboxAuthToAnyServicesRepository {
    UserOutboxAuthToAnyServicesMessage save(UserOutboxAuthToAnyServicesMessage userOutboxMessage);

    Optional<List<UserOutboxAuthToAnyServicesMessage>> findByTypeAndOutboxStatusAndSagaStatus(String type,
                                                                                              OutboxStatus outboxStatus,
                                                                                              SagaStatus... sagaStatus);
    Optional<UserOutboxAuthToAnyServicesMessage> findByTypeAndSagaIdAndServiceNameAndSagaStatus(String type,
                                                                                                UUID sagaId,
                                                                                                ServiceName serviceName,
                                                                                                SagaStatus... sagaStatus);
    void deleteByTypeAndOutboxStatusAndSagaStatus(String type,
                                                  OutboxStatus outboxStatus,
                                                  SagaStatus... sagaStatus);

    Optional<UserOutboxAuthToAnyServicesMessage> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String userSagaName,
                                                                                                UUID sagaId,
                                                                                                CopyState copyState,
                                                                                                OutboxStatus completed);
}
