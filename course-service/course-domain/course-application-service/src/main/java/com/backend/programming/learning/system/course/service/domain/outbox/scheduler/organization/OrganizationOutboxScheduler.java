package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.organization;

import com.backend.programming.learning.system.course.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.organization.OrganizationResponseMessagePublisher;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
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
    private final OrganizationResponseMessagePublisher organizationResponseMessagePublisher;

    public OrganizationOutboxScheduler(OrganizationOutboxHelper organizationOutboxHelper, OrganizationResponseMessagePublisher organizationResponseMessagePublisher) {
        this.organizationOutboxHelper = organizationOutboxHelper;
        this.organizationResponseMessagePublisher = organizationResponseMessagePublisher;
    }

    @Override
    @Transactional
    @Scheduled(fixedRateString = "${course-service.outbox-scheduler-fixed-rate}",
    initialDelayString = "${course-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<OrganizationOutboxMessage>> organizationOutboxMessages =
                organizationOutboxHelper.getOrganizationOutboxMessageByOutboxStatus(OutboxStatus.STARTED);
        if (organizationOutboxMessages.isPresent() && organizationOutboxMessages.get().size() > 0) {
            List<OrganizationOutboxMessage> outboxMessages = organizationOutboxMessages.get();
            log.info("Received {} OrganizationOutboxMessage with ids {}, sending to kafka!", outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(userOutboxMessage -> {
                organizationResponseMessagePublisher.publish(userOutboxMessage, organizationOutboxHelper::updateOutboxMessage);
            });
            log.info("{} UserOutboxMessage sent to message bus!", outboxMessages.size());
        }
    }
}
