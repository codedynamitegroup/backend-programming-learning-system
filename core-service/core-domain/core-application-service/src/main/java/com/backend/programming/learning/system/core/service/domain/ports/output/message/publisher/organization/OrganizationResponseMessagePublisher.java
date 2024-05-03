package com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.organization;

import com.backend.programming.learning.system.core.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface OrganizationResponseMessagePublisher {
    void publish(OrganizationOutboxMessage organizationOutboxMessage,
                 BiConsumer<OrganizationOutboxMessage, OutboxStatus> outboxCallback);
}
