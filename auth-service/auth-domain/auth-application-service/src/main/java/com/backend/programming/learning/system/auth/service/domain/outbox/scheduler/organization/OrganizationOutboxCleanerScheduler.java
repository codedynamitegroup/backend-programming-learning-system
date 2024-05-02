package com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.organization;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user.UserOutboxHelper;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class OrganizationOutboxCleanerScheduler implements OutboxScheduler {
    private final OrganizationOutboxHelper organizationOutboxHelper;

    public OrganizationOutboxCleanerScheduler(OrganizationOutboxHelper organizationOutboxHelper) {
        this.organizationOutboxHelper = organizationOutboxHelper;
    }

    @Override
    @Scheduled(cron = "@midnight")
    public void processOutboxMessage() {
        Optional<List<OrganizationOutboxMessage>> organizationOutboxMessagesResponse = organizationOutboxHelper
                .getOrganizationOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus.COMPLETED,
                        SagaStatus.SUCCEEDED, SagaStatus.FAILED, SagaStatus.COMPENSATED);
        if (organizationOutboxMessagesResponse.isPresent()) {
            List<OrganizationOutboxMessage> organizationOutboxMessages = organizationOutboxMessagesResponse.get();
            log.info("Received {} OrganizationOutboxMessages for clean-up. The payloads: {}",
                    organizationOutboxMessages.size(),
                    organizationOutboxMessages.stream().map(OrganizationOutboxMessage::getPayload)
                            .collect(Collectors.joining("\n")));
            organizationOutboxHelper.deleteUserOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus.COMPLETED,
                    SagaStatus.SUCCEEDED, SagaStatus.FAILED, SagaStatus.COMPENSATED);
            log.info("{} UserOutboxMessage deleted!", organizationOutboxMessages.size());
        }
    }
}
