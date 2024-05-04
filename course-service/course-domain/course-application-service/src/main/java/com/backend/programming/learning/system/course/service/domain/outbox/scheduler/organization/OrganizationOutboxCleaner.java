package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.organization;

import com.backend.programming.learning.system.course.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class OrganizationOutboxCleaner implements OutboxScheduler {
    private final OrganizationOutboxHelper organizationOutboxHelper;

    public OrganizationOutboxCleaner(OrganizationOutboxHelper organizationOutboxHelper) {
        this.organizationOutboxHelper = organizationOutboxHelper;
    }

    @Override
    @Scheduled(cron = "@midnight")
    @Transactional
    public void processOutboxMessage() {
        Optional<List<OrganizationOutboxMessage>> outboxMessagesResponse =
                organizationOutboxHelper.getOrganizationOutboxMessageByOutboxStatus(OutboxStatus.COMPLETED);
        if (outboxMessagesResponse.isPresent() && outboxMessagesResponse.get().size() > 0) {
            List<OrganizationOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} UserOutboxMessage for clean-up!", outboxMessages.size());
            organizationOutboxHelper.deleteOrganizationOutboxMessageByOutboxStatus(OutboxStatus.COMPLETED);
            log.info("Deleted {} UserOutboxMessage!", outboxMessages.size());
        }
    }
}
