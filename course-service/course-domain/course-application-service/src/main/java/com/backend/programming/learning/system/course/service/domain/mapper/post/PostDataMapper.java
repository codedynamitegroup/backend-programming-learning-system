package com.backend.programming.learning.system.course.service.domain.mapper.post;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.post.CreatePostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.post.CreatePostResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.post.QueryAllPostResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.post.PostResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Post;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.mapper.post
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 11:36 PM
 * Description: ...
 */
@Component
public class PostDataMapper {
    public Post createPostCommandToPost(CreatePostCommand createPostCommand, Course course, User createdBy) {
        return Post.builder()
                .course(course)
                .title(createPostCommand.title())
                .content(createPostCommand.content())
                .summary(createPostCommand.summary())
                .isPublished(createPostCommand.isPublished())
                .createdBy(createdBy)
                .build();
    }

    public CreatePostResponse postToCreatePostResponse(Post post, String message) {
        return CreatePostResponse.builder()
                .id(post.getId())
                .courseId(post.getCourse().getId())
                .title(post.getTitle())
                .content(post.getContent())
                .summary(post.getSummary())
                .isPublished(post.getPublished())
                .message(message)
                .build();
    }

    public PostResponseEntity postToPostResponseEntity(Post post) {
        return PostResponseEntity.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .summary(post.getSummary())
                .isPublished(post.getPublished())
                .createdBy(post.getCreatedBy().getId())
                .build();
    }

    public QueryAllPostResponse postPageToQueryAllPostResponse(Page<Post> posts) {
        return QueryAllPostResponse.builder()
                .posts(posts.map(this::postToPostResponseEntity).getContent())
                .currentPage(posts.getNumber())
                .totalItems(posts.getTotalElements())
                .totalPages(posts.getTotalPages())
                .build();
    }
}
