package com.backend.programming.learning.system.core.service.domain.event;

import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;

public abstract class TopicEvent implements DomainEvent<Topic> {
    private final Topic topic;
    private final ZonedDateTime createdAt;

    public TopicEvent(Topic topic, ZonedDateTime createdAt) {
        this.topic = topic;
        this.createdAt = createdAt;
    }

    public Topic getCertificateCourseTopic() {
        return topic;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
