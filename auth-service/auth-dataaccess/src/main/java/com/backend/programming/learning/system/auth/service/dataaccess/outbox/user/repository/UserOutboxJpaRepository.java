package com.backend.programming.learning.system.auth.service.dataaccess.outbox.user.repository;

import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user.entity.UserOutboxEntity;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.domain.valueobject.UserOutboxServiceType;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserOutboxJpaRepository extends JpaRepository<UserOutboxEntity, UUID> {

    Optional<List<UserOutboxEntity>> findByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                                              OutboxStatus outboxStatus,
                                                                              List<SagaStatus> sagaStatus);
    void deleteByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                    OutboxStatus outboxStatus,
                                                    List<SagaStatus> sagaStatus);

    Optional<UserOutboxEntity> findByTypeAndSagaIdAndCopyStateAndServiceName(String type,
                                                                                                        UUID sagaId,
                                                                                                        CopyState copyState,
                                                                                                        ServiceName serviceName);

    Optional<UserOutboxEntity> findByTypeAndSagaIdAndSagaStatusAndServiceName(String type,
                                                                              UUID sagaId,
                                                                              SagaStatus sagaStatus,
                                                                              ServiceName serviceName);


}
