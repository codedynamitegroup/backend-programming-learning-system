package com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_auth_to_any_services.UserOutboxAuthToAnyServicesMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface UserRequestAuthToAnyServicesMessagePublisher {
    void publish(UserOutboxAuthToAnyServicesMessage userOutboxMessage,
                 BiConsumer<UserOutboxAuthToAnyServicesMessage, OutboxStatus> outboxCallback);
}
