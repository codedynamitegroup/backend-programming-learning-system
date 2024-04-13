package com.backend.programming.learning.system.course.service.domain.service.post;

import com.backend.programming.learning.system.course.service.domain.entity.post.Post;
import com.backend.programming.learning.system.course.service.domain.event.post.PostCreateEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.domain.service.post
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:41 AM
 * Description: ...
 */
@Slf4j
public class PostDomainServiceImpl implements PostDomainService{
    @Override
    public PostCreateEvent validateAndInitiatePost(Post post) {
        log.info("validateAndInitiatePost");
        return new PostCreateEvent(post, LocalDateTime.now());
    }
}
