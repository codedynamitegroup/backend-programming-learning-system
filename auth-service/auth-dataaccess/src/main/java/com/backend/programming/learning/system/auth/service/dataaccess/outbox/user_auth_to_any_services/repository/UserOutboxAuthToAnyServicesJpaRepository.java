package com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_auth_to_any_services.repository;

import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_auth_to_any_services.entity.UserOutboxAuthToAnyServicesEntity;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserOutboxAuthToAnyServicesJpaRepository extends JpaRepository<UserOutboxAuthToAnyServicesEntity, UUID> {

    Optional<List<UserOutboxAuthToAnyServicesEntity>> findByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                                                               OutboxStatus outboxStatus,
                                                                                               List<SagaStatus> sagaStatus);

    Optional<UserOutboxAuthToAnyServicesEntity> findByTypeAndSagaIdAndServiceNameAndSagaStatusIn(String type,
                                                                                                 UUID sagaId,
                                                                                                 ServiceName serviceName,
                                                                                                 List<SagaStatus> sagaStatus);

    void deleteByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                    OutboxStatus outboxStatus,
                                                    List<SagaStatus> sagaStatus);

    Optional<UserOutboxAuthToAnyServicesEntity> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String type,
                                                                                               UUID sagaId,
                                                                                               CopyState copyState,
                                                                                               OutboxStatus outboxStatus);


}
