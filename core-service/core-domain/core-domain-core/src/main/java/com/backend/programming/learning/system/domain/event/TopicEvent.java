package com.backend.programming.learning.system.domain.event;

import com.backend.programming.learning.system.domain.entity.Topic;

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
