package com.backend.programming.learning.system.course.service.domain.service.post;

import com.backend.programming.learning.system.course.service.domain.dto.post.create.CreatePostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.post.create.CreatePostResponse;
import com.backend.programming.learning.system.course.service.domain.dto.post.get.PostResponse;
import com.backend.programming.learning.system.course.service.domain.entity.post.Post;
import com.backend.programming.learning.system.course.service.domain.event.post.PostCreateEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.post.PostDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.post.PostApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.course.service.domain.service.post
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:09 AM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class PostApplicationServiceImpl implements PostApplicationService {
   private final PostCreateCommandHandler postCreateCommandHandler;
   private final PostDataMapper postDataMapper;

    @Override
    public PostResponse findAll(String search) {
        return postCreateCommandHandler.findAll(search);
    }

    @Override
    public CreatePostResponse createPost(CreatePostCommand createPostCommand) {
        PostCreateEvent postCreateEvent = postCreateCommandHandler.createPost(createPostCommand);
        return postDataMapper.postCreateEventToCreatePostResponse(postCreateEvent, "Post created successfully");
    }

    @Override
    public CreatePostResponse getPost(Long postId) {
        Post post = postCreateCommandHandler.getPost(postId);
        return postDataMapper.postToCreatePostResponses(post, "Post get successfully");
    }

    @Override
    public void deletePost(Long postId) {
        postCreateCommandHandler.deletePost(postId);
    }
}
