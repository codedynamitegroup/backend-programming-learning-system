package com.backend.programming.learning.system.implement.post;

import com.backend.programming.learning.system.dto.method.create.post.CreatePostCommand;
import com.backend.programming.learning.system.dto.method.create.post.CreatePostResponse;
import com.backend.programming.learning.system.dto.method.query.post.QueryAllPostCommand;
import com.backend.programming.learning.system.dto.method.query.post.QueryAllPostResponse;
import com.backend.programming.learning.system.dto.method.query.post.QueryPostCommand;
import com.backend.programming.learning.system.dto.responseentity.post.PostResponseEntity;
import com.backend.programming.learning.system.entity.Post;
import com.backend.programming.learning.system.mapper.post.PostDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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
    private final PostQueryHelper postQueryHelper;

    private final PostDataMapper postDataMapper;

    @Transactional
    public CreatePostResponse createPost(CreatePostCommand createPostCommand) {
        Post post = postCreateHelper.createPost(createPostCommand);
        log.info("Post is created with id: {}", post.getId());
        return postDataMapper.postToCreatePostResponse(post, "Post created successfully");
    }

    @Transactional(readOnly = true)
    public QueryAllPostResponse findAll(QueryAllPostCommand queryAllPostCommand) {
        Page<Post> posts = postQueryHelper.findAll(queryAllPostCommand);
        log.info("Found {} posts", posts.getTotalElements());
        return postDataMapper.postPageToQueryAllPostResponse(posts);
    }

    @Transactional(readOnly = true)
    public PostResponseEntity findById(QueryPostCommand createPostCommand) {
        Post post = postQueryHelper.findById(createPostCommand);
        log.info("Found post with id: {}", post.getId());
        return postDataMapper.postToPostResponseEntity(post);
    }
}
