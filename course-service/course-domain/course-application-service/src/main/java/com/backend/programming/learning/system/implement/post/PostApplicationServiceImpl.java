package com.backend.programming.learning.system.implement.post;

import com.backend.programming.learning.system.dto.method.create.post.CreatePostCommand;
import com.backend.programming.learning.system.dto.method.create.post.CreatePostResponse;
import com.backend.programming.learning.system.ports.input.service.post.PostApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.implemtent.post
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 10:57 PM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class PostApplicationServiceImpl implements PostApplicationService {
    private final PostCommandHandler postCommandHandler;
    @Override
    public CreatePostResponse createPost(CreatePostCommand createPostCommand) {
        return postCommandHandler.createPost(createPostCommand);
    }
}
