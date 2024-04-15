package com.backend.programming.learning.system.auth.service.messaging.publisher.kafka;

import com.backend.programming.learning.system.auth.service.domain.event.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserCreatedMessagePublisher;
import org.springframework.stereotype.Component;

@Component
public class CreateUserKafkaMessagePublisher implements UserCreatedMessagePublisher {

    @Override
    public void publish(UserCreatedEvent domainEvent) {

    }
}
