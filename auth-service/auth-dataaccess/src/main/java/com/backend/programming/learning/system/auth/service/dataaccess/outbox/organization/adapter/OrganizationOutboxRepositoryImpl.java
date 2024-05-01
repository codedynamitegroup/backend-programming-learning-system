package com.backend.programming.learning.system.auth.service.dataaccess.outbox.organization.adapter;

import com.backend.programming.learning.system.auth.service.dataaccess.outbox.organization.exception.OrganizationOutboxNotFoundException;
import com.backend.programming.learning.system.auth.service.dataaccess.outbox.organization.mapper.OrganizationOutboxDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.outbox.organization.repository.OrganizationOutboxJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationOutboxRepository;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrganizationOutboxRepositoryImpl implements OrganizationOutboxRepository {

    private final OrganizationOutboxJpaRepository organizationOutboxJpaRepository;
    private final OrganizationOutboxDataAccessMapper organizationOutboxDataAccessMapper;

    public OrganizationOutboxRepositoryImpl(OrganizationOutboxJpaRepository organizationOutboxJpaRepository, OrganizationOutboxDataAccessMapper organizationOutboxDataAccessMapper) {
        this.organizationOutboxJpaRepository = organizationOutboxJpaRepository;
        this.organizationOutboxDataAccessMapper = organizationOutboxDataAccessMapper;
    }


    @Override
    public OrganizationOutboxMessage save(OrganizationOutboxMessage organizationOutboxMessage) {
        return organizationOutboxDataAccessMapper
                .organizationOutboxEntityToOrganizationOutboxMessage(organizationOutboxJpaRepository
                        .save(organizationOutboxDataAccessMapper
                                .organizationOutboxMessageToOrganizationOutboxEntity(organizationOutboxMessage)));
    }

    @Override
    public Optional<List<OrganizationOutboxMessage>> findByTypeAndOutboxStatusAndSagaStatus(String sagaType,
                                                                                            OutboxStatus outboxStatus,
                                                                                            SagaStatus... sagaStatus) {
        return Optional.of(organizationOutboxJpaRepository.findByTypeAndOutboxStatusAndSagaStatusIn(sagaType,
                        outboxStatus,
                        Arrays.asList(sagaStatus))
                .orElseThrow(() -> new OrganizationOutboxNotFoundException("Organization outbox object " +
                        "could not be found for saga type " + sagaType))
                .stream()
                .map(organizationOutboxDataAccessMapper::organizationOutboxEntityToOrganizationOutboxMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<OrganizationOutboxMessage> findByTypeAndSagaIdAndSagaStatus(String type,
                                                                                UUID sagaId,
                                                                                SagaStatus... sagaStatus) {
        return organizationOutboxJpaRepository
                .findByTypeAndSagaIdAndSagaStatusIn(type, sagaId, Arrays.asList(sagaStatus))
                .map(organizationOutboxDataAccessMapper::organizationOutboxEntityToOrganizationOutboxMessage);
    }

    @Override
    public void deleteByTypeAndOutboxStatusAndSagaStatus(String type, OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        organizationOutboxJpaRepository.deleteByTypeAndOutboxStatusAndSagaStatusIn(type, outboxStatus,
                Arrays.asList(sagaStatus));
    }
}
