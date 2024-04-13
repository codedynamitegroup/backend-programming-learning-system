package com.backend.programming.learning.system.course.service.domain.ports.input.service.post;

import com.backend.programming.learning.system.course.service.domain.dto.post.create.CreatePostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.post.create.CreatePostResponse;
import com.backend.programming.learning.system.course.service.domain.dto.post.get.PostResponse;

/**
 * com.backend.programming.learning.system.course.service.domain.ports.input.service.post
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:09 AM
 * Description: ...
 */
public interface PostApplicationService {
    PostResponse findAll(String search);

    CreatePostResponse createPost(CreatePostCommand createPostCommand);

    CreatePostResponse getPost(Long postId);

    void deletePost(Long postId);
}
