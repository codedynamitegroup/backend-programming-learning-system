package com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.organization;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface OrganizationRequestMessagePublish {
    void publish(OrganizationOutboxMessage organizationOutboxMessage,
                 BiConsumer<OrganizationOutboxMessage, OutboxStatus> outboxCallback);
}
