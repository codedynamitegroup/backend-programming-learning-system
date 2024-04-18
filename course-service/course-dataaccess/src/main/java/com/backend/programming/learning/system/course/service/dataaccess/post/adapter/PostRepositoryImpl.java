package com.backend.programming.learning.system.course.service.dataaccess.post.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.post.mapper.PostDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.post.repository.PostJpaRepository;
import com.backend.programming.learning.system.entity.Post;
import com.backend.programming.learning.system.ports.output.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostJpaRepository postJpaRepository;
    private final PostDataAccessMapper postDataAccessMapper;

    @Override
    public Post save(Post post) {
        return postDataAccessMapper
                .postEntityToPost(postJpaRepository
                        .save(postDataAccessMapper
                                .postToPostEntity(post)));
    }

    @Override
    public Page<Post> findAll(Integer pageNo, Integer pageSize) {
        return postJpaRepository.findAll(PageRequest.of(pageNo, pageSize))
                .map(postDataAccessMapper::postEntityToPost);
    }

    @Override
    public Post findById(UUID postId) {
        return postDataAccessMapper
                .postEntityToPost(postJpaRepository
                        .findById(postId)
                        .orElseThrow(() -> new RuntimeException("Post not found")));
    }
}
