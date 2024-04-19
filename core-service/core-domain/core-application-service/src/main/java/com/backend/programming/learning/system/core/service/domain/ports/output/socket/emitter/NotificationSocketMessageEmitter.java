package com.backend.programming.learning.system.core.service.domain.ports.output.socket.emitter;

import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.socket.notification.message.NotificationMessage;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;
import com.backend.programming.learning.system.domain.socket.DomainSocketMessage;
import com.backend.programming.learning.system.domain.socket.emitter.DomainSocketMessageEmitter;

public interface NotificationSocketMessageEmitter<K> extends DomainSocketMessageEmitter<NotificationMessage<K>> {
}
