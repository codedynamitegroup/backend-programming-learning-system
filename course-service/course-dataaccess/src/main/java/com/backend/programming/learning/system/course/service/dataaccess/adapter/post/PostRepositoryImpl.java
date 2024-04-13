package com.backend.programming.learning.system.course.service.dataaccess.adapter.post;

import com.backend.programming.learning.system.course.service.dataaccess.mapper.post.PostDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.repository.post.PostJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.post.Post;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.adapter.post
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:11 AM
 * Description: ...
 */
@Component
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostJpaRepository postRepository;
    private final PostDataAccessMapper postDataAccessMapper;
    @Override
    public Post createPost(Post post) {
        return postDataAccessMapper.postEntityToPost(
                postRepository.save(postDataAccessMapper.postToPostEntity(post)));
    }

    @Override
    public List<Post> findAll(String search) {
        return postRepository.findAll()
                .stream().map(postDataAccessMapper::postEntityToPost)
                .toList();
    }

    @Override
    public Post getPost(Long postId) {
        return postDataAccessMapper.postEntityToPost(
                postRepository.findById(postId)
                        .orElseThrow(() -> new RuntimeException("Post not found")));
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
