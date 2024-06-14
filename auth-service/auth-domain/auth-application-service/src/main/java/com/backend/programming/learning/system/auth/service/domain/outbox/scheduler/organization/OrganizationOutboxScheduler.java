package com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.organization;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.organization.OrganizationRequestMessagePublish;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class OrganizationOutboxScheduler implements OutboxScheduler {
    private final OrganizationOutboxHelper organizationOutboxHelper;
    private final OrganizationRequestMessagePublish organizationRequestMessagePublish;

    public OrganizationOutboxScheduler(OrganizationOutboxHelper organizationOutboxHelper, OrganizationRequestMessagePublish organizationRequestMessagePublish) {
        this.organizationOutboxHelper = organizationOutboxHelper;
        this.organizationRequestMessagePublish = organizationRequestMessagePublish;
    }


    @Override
    @Transactional
//    @Scheduled(fixedDelayString = "${auth-service.outbox-scheduler-fixed-rate}",
//        initialDelayString = "${auth-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<OrganizationOutboxMessage>> outboxMessagesResponse =
                organizationOutboxHelper.getOrganizationOutboxMessageByOutboxStatusAndSagaStatus(
                        OutboxStatus.STARTED,
                        SagaStatus.STARTED, SagaStatus.COMPENSATING);
        if (outboxMessagesResponse.isPresent() && outboxMessagesResponse.get().size() > 0) {
            List<OrganizationOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} OrganizationOutboxMessage with ids: {}, sending to message bus!",
                    outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(outboxMessage ->
                    organizationRequestMessagePublish.publish(outboxMessage, this::updateOutboxStatus));
            log.info("{} OrganizationOutboxMessage sent to message bus!", outboxMessages.size());
        }
    }

    private void updateOutboxStatus(OrganizationOutboxMessage organizationOutboxMessage, OutboxStatus outboxStatus) {
        organizationOutboxMessage.setOutboxStatus(outboxStatus);
        organizationOutboxHelper.save(organizationOutboxMessage);
        log.info("OrganizationOutboxMessage is updated with outbox status: {}", outboxStatus.name());
    }
}
