package com.backend.programming.learning.system.implement.post;

import com.backend.programming.learning.system.dto.method.delete.post.DeletePostCommand;
import com.backend.programming.learning.system.ports.output.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.implement.post
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 11:31 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PostDeleteHelper {
    private final PostRepository postRepository;
    public void deleteById(DeletePostCommand deletePostCommand) {
        log.info("Delete post by id: {}", deletePostCommand.postId());
        postRepository.deleteById(deletePostCommand.postId());
    }
}
