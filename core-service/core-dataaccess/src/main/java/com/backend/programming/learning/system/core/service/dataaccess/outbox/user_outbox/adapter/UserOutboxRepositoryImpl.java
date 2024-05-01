package com.backend.programming.learning.system.core.service.dataaccess.outbox.user_outbox.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.outbox.user_outbox.exception.UserOutboxNotFoundException;
import com.backend.programming.learning.system.core.service.dataaccess.outbox.user_outbox.mapper.UserOutboxDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.outbox.user_outbox.repository.UserOutboxJpaRepository;
import com.backend.programming.learning.system.core.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserOutboxRepository;
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
public class UserOutboxRepositoryImpl implements UserOutboxRepository {

    private final UserOutboxJpaRepository userOutboxJpaRepository;
    private final UserOutboxDataAccessMapper userOutboxDataAccessMapper;

    public UserOutboxRepositoryImpl(UserOutboxJpaRepository userOutboxJpaRepository, UserOutboxDataAccessMapper userOutboxDataAccessMapper) {
        this.userOutboxJpaRepository = userOutboxJpaRepository;
        this.userOutboxDataAccessMapper = userOutboxDataAccessMapper;
    }

    @Override
    public UserOutboxMessage save(UserOutboxMessage userOutboxMessage) {
        return userOutboxDataAccessMapper
                .userOutboxEntityToUserOutboxMessage(userOutboxJpaRepository
                        .save(userOutboxDataAccessMapper
                                .userOutboxMessageToUserOutboxEntity(userOutboxMessage)));
    }

    @Override
    public Optional<List<UserOutboxMessage>> findByTypeAndOutboxStatus(String sagaType, OutboxStatus outboxStatus) {
        return Optional.of(userOutboxJpaRepository.findByTypeAndOutboxStatus(sagaType, outboxStatus)
                .orElseThrow(() -> new UserOutboxNotFoundException("User outbox object " +
                        "could not be found for saga type " + sagaType))
                .stream()
                .map(userOutboxDataAccessMapper::userOutboxEntityToUserOutboxMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<UserOutboxMessage> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String sagaType,
                                                                               UUID sagaId,
                                                                               CopyState copyState,
                                                                               OutboxStatus outboxStatus) {
        return userOutboxJpaRepository
                .findByTypeAndSagaIdAndCopyStateAndOutboxStatus(sagaType, sagaId, copyState, outboxStatus)
                .map(userOutboxDataAccessMapper::userOutboxEntityToUserOutboxMessage);
    }

    @Override
    public void deleteByTypeAndOutboxStatus(String sagaType, OutboxStatus outboxStatus) {
        userOutboxJpaRepository.deleteByTypeAndOutboxStatus(sagaType, outboxStatus);
    }
}
