package com.backend.programming.learning.system.course.service.domain.implement.service.post;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.post.QueryAllPostByCourseIdCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.post.QueryPostCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Post;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
    public Page<Post> findAllByCourseId(QueryAllPostByCourseIdCommand queryAllPostCommand) {
        return postRepository.findAllByCourseId(
                queryAllPostCommand.getCourseId(),
                queryAllPostCommand.getPageNo(),
                queryAllPostCommand.getPageSize());
    }

    public Post findById(QueryPostCommand createPostCommand) {
        Optional<Post> postFound = postRepository.findById(createPostCommand.getPostId());
        if (postFound.isEmpty()) {
            log.warn("Post with id: {} not found", createPostCommand.getPostId());
            throw new CourseDomainException("Post not found");
        }
        return postFound.get();
    }
}
