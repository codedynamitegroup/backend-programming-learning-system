package com.backend.programming.learning.system.implement.post;

import com.backend.programming.learning.system.dto.method.create.post.CreatePostCommand;
import com.backend.programming.learning.system.dto.method.create.post.CreatePostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.backend.programming.learning.system.implemtent.post
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 10:57 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PostCommandHandler {
    private final PostCreateHelper postCreateHelper;
//    private final PostDataMapper postDataMapper;
    @Transactional
    public CreatePostResponse createPost(CreatePostCommand createPostCommand) {
return null;
    }
}