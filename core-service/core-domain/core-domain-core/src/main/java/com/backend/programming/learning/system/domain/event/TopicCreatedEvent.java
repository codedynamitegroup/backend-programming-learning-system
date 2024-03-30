package com.backend.programming.learning.system.domain.event;

import com.backend.programming.learning.system.domain.entity.Topic;

import java.time.ZonedDateTime;

public class TopicCreatedEvent extends TopicEvent {

    public TopicCreatedEvent(Topic topic, ZonedDateTime createdAt) {
        super(topic, createdAt);
    }
}
