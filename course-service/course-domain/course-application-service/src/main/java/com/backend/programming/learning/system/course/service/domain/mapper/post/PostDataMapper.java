package com.backend.programming.learning.system.course.service.domain.mapper.post;

import com.backend.programming.learning.system.course.service.domain.dto.post.create.CreatePostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.post.create.CreatePostResponse;
import com.backend.programming.learning.system.course.service.domain.dto.post.get.PostResponse;
import com.backend.programming.learning.system.course.service.domain.entity.post.Post;
import com.backend.programming.learning.system.course.service.domain.event.post.PostCreateEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.mapper.post
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:15 AM
 * Description: ...
 */
@Component
public class PostDataMapper {
    public CreatePostResponse postCreateEventToCreatePostResponse(PostCreateEvent postCreateEvent, String message) {
        return new CreatePostResponse(postCreateEvent.getPost(), message);
    }

    public Post createPostCommandToPost(CreatePostCommand createPostCommand) {
        return new Post(
                createPostCommand.getCourseId(),
                createPostCommand.getTitle(),
                createPostCommand.getSummary(),
                createPostCommand.getContent(),
                createPostCommand.getPublishState()
        );
    }

    public PostResponse postsToCreatePostResponses(List<Post> posts, String message) {
        return new PostResponse(posts, message);
    }

    public CreatePostResponse postToCreatePostResponses(Post post, String message) {
        return new CreatePostResponse(post, message);
    }
}
