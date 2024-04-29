package com.backend.programming.learning.system.core.service.dataaccess.outbox.contest_user_update_outbox.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.organization.repository.OrganizationJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.outbox.contest_user_update_outbox.exception.ContestUserUpdateOutboxNotFoundException;
import com.backend.programming.learning.system.core.service.dataaccess.outbox.contest_user_update_outbox.mapper.ContestUserUpdateOutboxDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.outbox.contest_user_update_outbox.repository.ContestUserUpdateOutboxJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserUpdateOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserUpdateOutboxRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ContestUserUpdateOutboxRepositoryImpl implements ContestUserUpdateOutboxRepository {

    private final ContestUserUpdateOutboxJpaRepository contestUserUpdateOutboxJpaRepository;
    private final ContestUserUpdateOutboxDataAccessMapper contestUserUpdateOutboxDataAccessMapper;

    public ContestUserUpdateOutboxRepositoryImpl(ContestUserUpdateOutboxJpaRepository contestUserUpdateOutboxJpaRepository,
                                                 ContestUserUpdateOutboxDataAccessMapper contestUserUpdateOutboxDataAccessMapper) {
        this.contestUserUpdateOutboxJpaRepository = contestUserUpdateOutboxJpaRepository;
        this.contestUserUpdateOutboxDataAccessMapper = contestUserUpdateOutboxDataAccessMapper;
    }

    @Override
    public ContestUserUpdateOutboxMessage save(ContestUserUpdateOutboxMessage contestUserUpdateOutboxMessage) {
        return contestUserUpdateOutboxDataAccessMapper
                .contestUserUpdateOutboxEntityToContestUserUpdateOutboxMessage(contestUserUpdateOutboxJpaRepository
                        .save(contestUserUpdateOutboxDataAccessMapper
                                .contestUserUpdateOutboxMessageToContestUserUpdateOutboxEntity(contestUserUpdateOutboxMessage)));
    }

    @Override
    public Optional<List<ContestUserUpdateOutboxMessage>> findByTypeAndOutboxStatusAndSagaStatus(String sagaType,
                                                                                                 OutboxStatus outboxStatus,
                                                                                                 SagaStatus... sagaStatus) {
        return Optional.of(contestUserUpdateOutboxJpaRepository.findByTypeAndOutboxStatusAndSagaStatusIn(sagaType,
                        outboxStatus,
                        Arrays.asList(sagaStatus))
                .orElseThrow(() -> new ContestUserUpdateOutboxNotFoundException("Contest user update outbox object " +
                        "could not be found for saga type " + sagaType))
                .stream()
                .map(contestUserUpdateOutboxDataAccessMapper::contestUserUpdateOutboxEntityToContestUserUpdateOutboxMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<ContestUserUpdateOutboxMessage> findByTypeAndSagaIdAndSagaStatus(String type, UUID sagaId, SagaStatus... sagaStatus) {
        return contestUserUpdateOutboxJpaRepository
                .findByTypeAndSagaIdAndSagaStatusIn(type, sagaId, Arrays.asList(sagaStatus))
                .map(contestUserUpdateOutboxDataAccessMapper::contestUserUpdateOutboxEntityToContestUserUpdateOutboxMessage);
    }

    @Override
    public void deleteByTypeAndOutboxStatusAndSagaStatus(String type, OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        contestUserUpdateOutboxJpaRepository.deleteByTypeAndOutboxStatusAndSagaStatusIn(type, outboxStatus,
                Arrays.asList(sagaStatus));
    }
}
