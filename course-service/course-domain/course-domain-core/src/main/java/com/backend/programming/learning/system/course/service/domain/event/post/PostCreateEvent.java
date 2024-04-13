package com.backend.programming.learning.system.course.service.domain.event.post;

import com.backend.programming.learning.system.course.service.domain.entity.post.Post;
import com.backend.programming.learning.system.event.DomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.domain.event.post
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:34 AM
 * Description: ...
 */
@Getter
public class PostCreateEvent implements DomainEvent<Post> {
    private final Post post;
    private final LocalDateTime createAt;

    public PostCreateEvent(Post post, LocalDateTime createAt) {
        this.post = post;
        this.createAt = LocalDateTime.now();
    }
}
