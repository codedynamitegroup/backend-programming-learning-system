package com.backend.programming.learning.system.course.service.domain.event;

import com.backend.programming.learning.system.course.service.domain.entity.Post;

import java.time.ZonedDateTime;

public class PostCreatedEvent extends PostEvent{
    public PostCreatedEvent(Post post, ZonedDateTime createdAt) {
        super(post, createdAt);
    }

    @Override
    public void fire() {

    }
}
