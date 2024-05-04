package com.backend.programming.learning.system.auth.service.dataaccess.outbox.user.adapter;

import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user.exception.UserOutboxNotFoundException;
import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user.mapper.UserOutboxDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user.repository.UserOutboxJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserOutboxRepository;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
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
    public Optional<UserOutboxMessage> findByTypeAndSagaIdAndServiceNameAndSagaStatus(String type,
                                                                                UUID sagaId,
                                                                                        ServiceName serviceName,
                                                                                SagaStatus... sagaStatus) {
        return userOutboxJpaRepository
                .findByTypeAndSagaIdAndServiceNameAndSagaStatusIn(type, sagaId, serviceName, Arrays.asList(sagaStatus))
                .map(userOutboxDataAccessMapper::userOutboxEntityToUserOutboxMessage);
    }

    @Override
    public void deleteByTypeAndOutboxStatusAndSagaStatus(String type, OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        userOutboxJpaRepository.deleteByTypeAndOutboxStatusAndSagaStatusIn(type, outboxStatus,
                Arrays.asList(sagaStatus));
    }
}
