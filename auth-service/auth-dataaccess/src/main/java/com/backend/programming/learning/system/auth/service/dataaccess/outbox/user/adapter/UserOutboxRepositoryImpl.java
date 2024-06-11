package com.backend.programming.learning.system.auth.service.dataaccess.outbox.user.adapter;

import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user.exception.UserOutboxNotFoundException;
import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user.mapper.UserOutboxDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user.repository.UserOutboxJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserOutboxRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.domain.valueobject.UserOutboxServiceType;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserOutboxRepositoryImpl implements UserOutboxRepository {

    private final UserOutboxJpaRepository userOutboxJpaRepository;
    private final UserOutboxDataAccessMapper userOutboxDataAccessMapper;

    @Override
    public UserOutboxMessage save(UserOutboxMessage userOutboxMessage) {
        return userOutboxDataAccessMapper
                .userOutboxEntityToUserOutboxMessage(userOutboxJpaRepository
                        .save(userOutboxDataAccessMapper
                                .userOutboxMessageToUserOutboxEntity(userOutboxMessage)));
    }

    @Override
    public Optional<List<UserOutboxMessage>> findByTypeAndOutboxStatusAndSagaStatus(String sagaType,
                                                                                                     OutboxStatus outboxStatus,
                                                                                                     SagaStatus... sagaStatus) {
        return Optional.of(userOutboxJpaRepository.findByTypeAndOutboxStatusAndSagaStatusIn(sagaType,
                        outboxStatus,
                        Arrays.asList(sagaStatus))
                .orElseThrow(() -> new UserOutboxNotFoundException("User outbox object " +
                        "could not be found for saga type " + sagaType))
                .stream()
                .map(userOutboxDataAccessMapper::userOutboxEntityToUserOutboxMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public void deleteByTypeAndOutboxStatusAndSagaStatus(String type, OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        userOutboxJpaRepository.deleteByTypeAndOutboxStatusAndSagaStatusIn(type, outboxStatus,
                Arrays.asList(sagaStatus));
    }

    @Override
    public Optional<UserOutboxMessage> findByTypeAndSagaIdAndSagaStatusAndServiceName(String sagaType,
                                                                                                       UUID sagaId,
                                                                                                       SagaStatus sagaStatus,
                                                                                                                     ServiceName serviceName) {
        return userOutboxJpaRepository
                .findByTypeAndSagaIdAndSagaStatusAndServiceName(sagaType, sagaId, sagaStatus, serviceName)
                .map(userOutboxDataAccessMapper::userOutboxEntityToUserOutboxMessage);
    }

    @Override
    public Optional<UserOutboxMessage> findByTypeAndSagaIdAndCopyStateAndServiceName(String sagaType, UUID sagaId, CopyState copyState, ServiceName serviceName) {
        return userOutboxJpaRepository
                .findByTypeAndSagaIdAndCopyStateAndServiceName(sagaType, sagaId, copyState, serviceName)
                .map(userOutboxDataAccessMapper::userOutboxEntityToUserOutboxMessage);
    }
}
