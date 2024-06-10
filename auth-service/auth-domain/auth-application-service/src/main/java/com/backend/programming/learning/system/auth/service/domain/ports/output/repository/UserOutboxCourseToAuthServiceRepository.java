package com.backend.programming.learning.system.auth.service.domain.ports.output.repository;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_course_to_auth_service.UserOutboxCourseToAuthServiceMessage;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserOutboxCourseToAuthServiceRepository {
    UserOutboxCourseToAuthServiceMessage save(UserOutboxCourseToAuthServiceMessage userOutboxMessage);

    Optional<List<UserOutboxCourseToAuthServiceMessage>> findByTypeAndOutboxStatusAndSagaStatus(String type,
                                                                                              OutboxStatus outboxStatus,
                                                                                              SagaStatus... sagaStatus);
    Optional<UserOutboxCourseToAuthServiceMessage> findByTypeAndSagaIdAndSagaStatus(String type,
                                                                                  UUID sagaId,
                                                                                  SagaStatus... sagaStatus);
    void deleteByTypeAndOutboxStatusAndSagaStatus(String type,
                                                  OutboxStatus outboxStatus,
                                                  SagaStatus... sagaStatus);

    Optional<UserOutboxCourseToAuthServiceMessage> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String userSagaName,
                                                                                                UUID sagaId,
                                                                                                CopyState copyState,
                                                                                                OutboxStatus completed);
}
