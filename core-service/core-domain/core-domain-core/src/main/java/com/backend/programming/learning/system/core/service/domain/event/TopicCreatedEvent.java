package com.backend.programming.learning.system.core.service.domain.event;

import com.backend.programming.learning.system.core.service.domain.entity.Topic;

import java.time.ZonedDateTime;

public class TopicCreatedEvent extends TopicEvent {

    public TopicCreatedEvent(Topic topic, ZonedDateTime createdAt) {
        super(topic, createdAt);
    }
}
