package com.backend.programming.learning.system.course.service.domain.service.post;

import com.backend.programming.learning.system.course.service.domain.dto.post.create.CreatePostCommand;
import com.backend.programming.learning.system.course.service.domain.dto.post.get.PostResponse;
import com.backend.programming.learning.system.course.service.domain.entity.post.Post;
import com.backend.programming.learning.system.course.service.domain.event.post.PostCreateEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.post.PostDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.service.post
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:10 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PostCreateCommandHandler {
    private final PostDomainService postDomainService;
    private final PostRepository postRepository;
    private final PostDataMapper postDataMapper;

    @Transactional
    public PostCreateEvent createPost(CreatePostCommand createPostCommand) {
        Post post = postDataMapper.createPostCommandToPost(createPostCommand);
        PostCreateEvent postCreateEvent = postDomainService.validateAndInitiatePost(post);
        Post savedPost = postRepository.createPost(postCreateEvent.getPost());
        if (savedPost == null) {
            log.error("Failed to save post");
            throw new RuntimeException("Failed to save post");
        }
        log.info("Post saved successfully");
        return postCreateEvent;
    }

    @Transactional(readOnly = true)
    public PostResponse findAll(String search) {
        List<Post> posts = postRepository.findAll(search);
        return postDataMapper.postsToCreatePostResponses(posts, "Get list post successfully");
    }

    @Transactional(readOnly = true)
    public Post getPost(Long postId) {
        return postRepository.getPost(postId);
    }

    @Transactional
    public void deletePost(Long postId) {
        postRepository.deletePost(postId);
    }
}
