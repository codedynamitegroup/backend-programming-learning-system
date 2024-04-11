package com.backend.programming.learning.system.event;

import com.backend.programming.learning.system.entity.Post;

import java.time.ZonedDateTime;

public class PostCreatedEvent extends PostEvent{
    public PostCreatedEvent(Post post, ZonedDateTime createdAt) {
        super(post, createdAt);
    }
}
