package com.backend.programming.learning.system.course.service.domain.event;

import com.backend.programming.learning.system.domain.event.DomainEvent;
import com.backend.programming.learning.system.course.service.domain.entity.Post;

import java.time.ZonedDateTime;

public abstract class PostEvent implements DomainEvent<Post> {
    private final Post post;
    private final ZonedDateTime createdAt;

    public PostEvent(Post post, ZonedDateTime createdAt) {
        this.post = post;
        this.createdAt = createdAt;
    }

    public Post getPost() {
        return post;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
