package com.backend.programming.learning.system.course.service.dataaccess.outbox.organization_outbox.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.outbox.organization_outbox.exception.OrganizationOutboxNotFoundException;
import com.backend.programming.learning.system.course.service.dataaccess.outbox.organization_outbox.mapper.OrganizationOutboxDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.outbox.organization_outbox.repository.OrganizationOutboxJpaRepository;
import com.backend.programming.learning.system.course.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.outbox.OrganizationOutboxRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import org.springframework.stereotype.Component;

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
    public Optional<List<OrganizationOutboxMessage>> findByTypeAndOutboxStatus(String sagaType, OutboxStatus outboxStatus) {
        return Optional.of(organizationOutboxJpaRepository.findByTypeAndOutboxStatus(sagaType, outboxStatus)
                .orElseThrow(() -> new OrganizationOutboxNotFoundException("Organization outbox object " +
                        "could not be found for saga type " + sagaType))
                .stream()
                .map(organizationOutboxDataAccessMapper::organizationOutboxEntityToOrganizationOutboxMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<OrganizationOutboxMessage> findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String sagaType,
                                                                               UUID sagaId,
                                                                               CopyState copyState,
                                                                               OutboxStatus outboxStatus) {
        return organizationOutboxJpaRepository
                .findByTypeAndSagaIdAndCopyStateAndOutboxStatus(sagaType, sagaId, copyState, outboxStatus)
                .map(organizationOutboxDataAccessMapper::organizationOutboxEntityToOrganizationOutboxMessage);
    }

    @Override
    public void deleteByTypeAndOutboxStatus(String sagaType, OutboxStatus outboxStatus) {
        organizationOutboxJpaRepository.deleteByTypeAndOutboxStatus(sagaType, outboxStatus);
    }
}
