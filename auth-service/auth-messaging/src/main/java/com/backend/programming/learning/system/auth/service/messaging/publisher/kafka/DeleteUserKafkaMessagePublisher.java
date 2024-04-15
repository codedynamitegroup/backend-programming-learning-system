package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka;

import com.backend.programming.learning.system.auth.service.domain.event.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserCreatedMessagePublisher;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserDeletedMessagePublisher;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserKafkaMessagePublisher implements UserDeletedMessagePublisher {

    @Override
    public void publish(UserDeletedEvent domainEvent) {

    }
}
