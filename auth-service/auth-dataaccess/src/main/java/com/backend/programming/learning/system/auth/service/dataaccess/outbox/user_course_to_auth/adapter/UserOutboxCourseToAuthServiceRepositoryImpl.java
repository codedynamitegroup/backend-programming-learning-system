package com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_course_to_auth.adapter;

import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_course_to_auth.exception.UserOutboxCourseToAuthServiceNotFoundException;
import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_course_to_auth.mapper.UserOutboxCourseToAuthServiceDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_course_to_auth.repository.UserOutboxCourseToAuthServiceJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_course_to_auth_service.UserOutboxCourseToAuthServiceMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserOutboxCourseToAuthServiceRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserOutboxCourseToAuthServiceRepositoryImpl implements UserOutboxCourseToAuthServiceRepository {

    private final UserOutboxCourseToAuthServiceJpaRepository userOutboxJpaRepository;
    private final UserOutboxCourseToAuthServiceDataAccessMapper userOutboxDataAccessMapper;

    public UserOutboxCourseToAuthServiceRepositoryImpl(UserOutboxCourseToAuthServiceJpaRepository userOutboxJpaRepository, UserOutboxCourseToAuthServiceDataAccessMapper userOutboxDataAccessMapper) {
        this.userOutboxJpaRepository = userOutboxJpaRepository;
        this.userOutboxDataAccessMapper = userOutboxDataAccessMapper;
    }

    @Override
    public UserOutboxCourseToAuthServiceMessage save(UserOutboxCourseToAuthServiceMessage userOutboxMessage) {
        return userOutboxDataAccessMapper
                .userOutboxEntityToUserOutboxMessage(userOutboxJpaRepository
                        .save(userOutboxDataAccessMapper
                                .userOutboxMessageToUserOutboxEntity(userOutboxMessage)));
    }

    @Override
    public Optional<List<UserOutboxCourseToAuthServiceMessage>> findByTypeAndOutboxStatusAndSagaStatus(String sagaType,
                                                                                                       OutboxStatus outboxStatus,
                                                                                                       SagaStatus... sagaStatus) {
        return Optional.of(userOutboxJpaRepository.findByTypeAndOutboxStatusAndSagaStatusIn(sagaType,
                        outboxStatus,
                        Arrays.asList(sagaStatus))
                .orElseThrow(() -> new UserOutboxCourseToAuthServiceNotFoundException("User outbox object " +
                        "could not be found for saga type " + sagaType))
                .stream()
                .map(userOutboxDataAccessMapper::userOutboxEntityToUserOutboxMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<UserOutboxCourseToAuthServiceMessage> findByTypeAndSagaIdAndSagaStatus(String type,
                                                                                         UUID sagaId,
                                                                                         SagaStatus... sagaStatus) {
        return userOutboxJpaRepository
                .findByTypeAndSagaIdAndSagaStatusIn(type, sagaId, Arrays.asList(sagaStatus))
                .map(userOutboxDataAccessMapper::userOutboxEntityToUserOutboxMessage);
    }

    @Override
    public void deleteByTypeAndOutboxStatusAndSagaStatus(String type, OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        userOutboxJpaRepository.deleteByTypeAndOutboxStatusAndSagaStatusIn(type, outboxStatus,
                Arrays.asList(sagaStatus));
    }

    @Override
    public Optional<UserOutboxCourseToAuthServiceMessage> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String sagaType,
                                                                                                       UUID sagaId,
                                                                                                       CopyState copyState,
                                                                                                       OutboxStatus outboxStatus) {
        return userOutboxJpaRepository
                .findByTypeAndSagaIdAndCopyStateAndOutboxStatus(sagaType, sagaId, copyState, outboxStatus)
                .map(userOutboxDataAccessMapper::userOutboxEntityToUserOutboxMessage);
    }
}
