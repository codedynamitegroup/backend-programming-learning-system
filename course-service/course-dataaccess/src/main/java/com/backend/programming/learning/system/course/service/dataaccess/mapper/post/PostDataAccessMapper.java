package com.backend.programming.learning.system.course.service.dataaccess.mapper.post;

import com.backend.programming.learning.system.course.service.dataaccess.entity.post.PostEntity;
import com.backend.programming.learning.system.course.service.domain.entity.post.Post;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.mapper.post
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:12 AM
 * Description: ...
 */
@Component
public class PostDataAccessMapper {
    public PostEntity postToPostEntity(Post post) {
        return PostEntity.builder()
                .courseId(post.getCourseId())
                .title(post.getTitle())
                .summary(post.getSummary())
                .content(post.getContent())
                .publishState(post.getPublishState())
                .createdBy(1L)
                .updatedBy(1L)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public Post postEntityToPost(PostEntity postEntity) {
        return Post.builder()
                .courseId(postEntity.getCourseId())
                .title(postEntity.getTitle())
                .summary(postEntity.getSummary())
                .content(postEntity.getContent())
                .publishState(postEntity.getPublishState())
                .build();
    }
}
