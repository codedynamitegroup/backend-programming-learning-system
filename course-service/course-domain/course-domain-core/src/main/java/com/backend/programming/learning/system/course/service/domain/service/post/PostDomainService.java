package com.backend.programming.learning.system.course.service.domain.service.post;

import com.backend.programming.learning.system.course.service.domain.entity.post.Post;
import com.backend.programming.learning.system.course.service.domain.event.post.PostCreateEvent;

/**
 * com.backend.programming.learning.system.course.service.domain.service.post
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:41 AM
 * Description: ...
 */
public interface PostDomainService {
    PostCreateEvent validateAndInitiatePost(Post post);
}
