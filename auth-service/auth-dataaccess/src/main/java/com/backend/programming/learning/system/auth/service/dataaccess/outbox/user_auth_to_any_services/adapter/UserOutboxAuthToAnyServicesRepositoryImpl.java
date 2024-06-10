package com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_auth_to_any_services.adapter;

import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_auth_to_any_services.mapper.UserOutboxAuthToAnyServicesDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_auth_to_any_services.exception.UserOutboxAuthToAnyServicesNotFoundException;
import com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_auth_to_any_services.repository.UserOutboxAuthToAnyServicesJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_auth_to_any_services.UserOutboxAuthToAnyServicesMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserOutboxAuthToAnyServicesRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
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
public class UserOutboxAuthToAnyServicesRepositoryImpl implements UserOutboxAuthToAnyServicesRepository {

    private final UserOutboxAuthToAnyServicesJpaRepository userOutboxJpaRepository;
    private final UserOutboxAuthToAnyServicesDataAccessMapper userOutboxDataAccessMapper;

    public UserOutboxAuthToAnyServicesRepositoryImpl(UserOutboxAuthToAnyServicesJpaRepository userOutboxJpaRepository, UserOutboxAuthToAnyServicesDataAccessMapper userOutboxDataAccessMapper) {
        this.userOutboxJpaRepository = userOutboxJpaRepository;
        this.userOutboxDataAccessMapper = userOutboxDataAccessMapper;
    }

    @Override
    public UserOutboxAuthToAnyServicesMessage save(UserOutboxAuthToAnyServicesMessage userOutboxMessage) {
        return userOutboxDataAccessMapper
                .userOutboxEntityToUserOutboxMessage(userOutboxJpaRepository
                        .save(userOutboxDataAccessMapper
                                .userOutboxMessageToUserOutboxEntity(userOutboxMessage)));
    }

    @Override
    public Optional<List<UserOutboxAuthToAnyServicesMessage>> findByTypeAndOutboxStatusAndSagaStatus(String sagaType,
                                                                                                     OutboxStatus outboxStatus,
                                                                                                     SagaStatus... sagaStatus) {
        return Optional.of(userOutboxJpaRepository.findByTypeAndOutboxStatusAndSagaStatusIn(sagaType,
                        outboxStatus,
                        Arrays.asList(sagaStatus))
                .orElseThrow(() -> new UserOutboxAuthToAnyServicesNotFoundException("User outbox object " +
                        "could not be found for saga type " + sagaType))
                .stream()
                .map(userOutboxDataAccessMapper::userOutboxEntityToUserOutboxMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<UserOutboxAuthToAnyServicesMessage> findByTypeAndSagaIdAndServiceNameAndSagaStatus(String type,
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

    @Override
    public Optional<UserOutboxAuthToAnyServicesMessage> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String sagaType,
                                                                                                       UUID sagaId,
                                                                                                       CopyState copyState,
                                                                                                       OutboxStatus outboxStatus) {
        return userOutboxJpaRepository
                .findByTypeAndSagaIdAndCopyStateAndOutboxStatus(sagaType, sagaId, copyState, outboxStatus)
                .map(userOutboxDataAccessMapper::userOutboxEntityToUserOutboxMessage);
    }
}
