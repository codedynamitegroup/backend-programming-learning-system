package com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_course_to_auth.repository;

import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_course_to_auth.entity.UserOutboxCourseToAuthServiceEntity;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserOutboxCourseToAuthServiceJpaRepository extends JpaRepository<UserOutboxCourseToAuthServiceEntity, UUID> {

    Optional<List<UserOutboxCourseToAuthServiceEntity>> findByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                                                                 OutboxStatus outboxStatus,
                                                                                                 List<SagaStatus> sagaStatus);

    Optional<UserOutboxCourseToAuthServiceEntity> findByTypeAndSagaIdAndSagaStatusIn(String type,
                                                                                     UUID sagaId,
                                                                                     List<SagaStatus> sagaStatus);

    void deleteByTypeAndOutboxStatusAndSagaStatusIn(String type,
                                                    OutboxStatus outboxStatus,
                                                    List<SagaStatus> sagaStatus);

    Optional<UserOutboxCourseToAuthServiceEntity> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String type,
                                                                                                 UUID sagaId,
                                                                                                 CopyState copyState,
                                                                                                 OutboxStatus outboxStatus);


}
