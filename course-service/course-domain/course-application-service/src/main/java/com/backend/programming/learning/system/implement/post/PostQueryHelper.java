package com.backend.programming.learning.system.implement.post;

import com.backend.programming.learning.system.dto.method.query.post.QueryAllPostCommand;
import com.backend.programming.learning.system.dto.method.query.post.QueryPostCommand;
import com.backend.programming.learning.system.entity.Post;
import com.backend.programming.learning.system.ports.output.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.implement.post
 * Create by Dang Ngoc Tien
 * Date 4/19/2024 - 1:33 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PostQueryHelper {
    private final PostRepository postRepository;
    public Page<Post> findAll(QueryAllPostCommand queryAllPostCommand) {
        return postRepository.findAll(queryAllPostCommand.getPageNo(), queryAllPostCommand.getPageSize());
    }

    public Post findById(QueryPostCommand createPostCommand) {
        return postRepository.findById(createPostCommand.getPostId());
    }
}
