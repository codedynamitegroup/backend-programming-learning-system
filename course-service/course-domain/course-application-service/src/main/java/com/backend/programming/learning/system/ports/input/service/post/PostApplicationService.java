package com.backend.programming.learning.system.ports.input.service.post;

import com.backend.programming.learning.system.dto.method.create.post.CreatePostCommand;
import com.backend.programming.learning.system.dto.method.create.post.CreatePostResponse;

import javax.validation.Valid;

/**
 * com.backend.programming.learning.system.ports.input.service.post
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 10:54 PM
 * Description: ...
 */
public interface PostApplicationService {
    CreatePostResponse createPost(
            @Valid CreatePostCommand createPostCommand);
}
