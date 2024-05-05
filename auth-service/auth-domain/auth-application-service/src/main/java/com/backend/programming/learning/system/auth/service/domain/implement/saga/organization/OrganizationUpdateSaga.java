package com.backend.programming.learning.system.auth.service.domain.implement.saga.organization;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.OrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.organization.OrganizationOutboxHelper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.saga.SagaStatus;
import com.backend.programming.learning.system.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrganizationUpdateSaga implements SagaStep<OrganizationResponse> {
    private final OrganizationOutboxHelper organizationOutboxHelper;
    private final OrganizationUpdateSagaHelper organizationUpdateSagaHelper;

    public OrganizationUpdateSaga(OrganizationOutboxHelper organizationOutboxHelper, OrganizationUpdateSagaHelper organizationUpdateSagaHelper) {
        this.organizationOutboxHelper = organizationOutboxHelper;
        this.organizationUpdateSagaHelper = organizationUpdateSagaHelper;
    }

    @Override
    @Transactional
    public void process(OrganizationResponse organizationResponse) {
        Optional<OrganizationOutboxMessage> organizationOutboxMessageResponse =
                organizationOutboxHelper.getOrganizationOutboxMessageBySagaIdAndServiceNameAndSagaStatus(
                        UUID.fromString(organizationResponse.getSagaId()), organizationResponse.getServiceName(), SagaStatus.STARTED);
        if (organizationOutboxMessageResponse.isEmpty()) {
            log.info("An outbox message with saga id: {} is already processed!", organizationResponse.getSagaId());
            return;
        }

        OrganizationOutboxMessage organizationOutboxMessage = organizationOutboxMessageResponse.get();

        SagaStatus sagaStatus = organizationUpdateSagaHelper.copyStatusToSagaStatus(organizationResponse.getState());

        //update outbox
        organizationOutboxHelper.save(updateOutboxMessage(organizationOutboxMessage, organizationResponse.getState(), sagaStatus
        ));

        log.info("Organization with id: {} is created successfully!", organizationResponse.getOrganizationId());
    }


    @Override
    @Transactional
    public void rollback(OrganizationResponse organizationResponse) {
        Optional<OrganizationOutboxMessage> organizationOutboxMessageResponse =
                organizationOutboxHelper.getOrganizationOutboxMessageBySagaIdAndServiceNameAndSagaStatus(
                        UUID.fromString(organizationResponse.getSagaId()),
                        organizationResponse.getServiceName(),
                        SagaStatus.STARTED);
        if (organizationOutboxMessageResponse.isEmpty()) {
            log.info("An outbox message with saga id: {} is already roll backed!", organizationResponse.getSagaId());
            return;
        }

        OrganizationOutboxMessage organizationOutboxMessage = organizationOutboxMessageResponse.get();

        SagaStatus sagaStatus = organizationUpdateSagaHelper.copyStatusToSagaStatus(organizationResponse.getState());

        //update outbox
        organizationOutboxHelper.save(updateOutboxMessage(organizationOutboxMessage, organizationResponse.getState(), sagaStatus
        ));

        log.info("Organization with id: {} is rollback!", organizationResponse.getOrganizationId());
    }

    private OrganizationOutboxMessage updateOutboxMessage(OrganizationOutboxMessage organizationOutboxMessage,
                                                                 CopyState copyState,
                                                                 SagaStatus sagaStatus) {
        organizationOutboxMessage.setProcessedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
        organizationOutboxMessage.setCopyState(copyState);
        organizationOutboxMessage.setSagaStatus(sagaStatus);
        return organizationOutboxMessage;
    }
}
