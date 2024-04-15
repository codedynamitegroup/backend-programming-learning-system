package com.backend.programming.learning.system.course.service.dataaccess.post.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.post.entity.PostEntity;
import com.backend.programming.learning.system.entity.Post;
import com.backend.programming.learning.system.valueobject.PostId;
import org.springframework.stereotype.Component;

@Component
public class PostDataAccessMapper {
    public PostEntity postToPostEntity(Post post) {
        return PostEntity.builder()
                .id(post.getId().getValue())
                .title(post.getTitle())
                .summary(post.getSummary())
                .content(post.getContent())
                .publishState(post.getPublished())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public Post postEntityToPost(PostEntity postEntity) {
        return Post.builder()
                .id(new PostId(postEntity.getId()))
                .title(postEntity.getTitle())
                .summary(postEntity.getSummary())
                .content(postEntity.getContent())
                .isPublished(postEntity.getPublishState())
                .createdAt(postEntity.getCreatedAt())
                .updatedAt(postEntity.getUpdatedAt())
                .build();
    }
}
