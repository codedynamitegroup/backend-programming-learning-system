package com.backend.programming.learning.system.course.service.dataaccess.post.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.post.entity.PostEntity;
import com.backend.programming.learning.system.course.service.dataaccess.post.mapper.PostDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.post.repository.PostJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.Post;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.PostRepository;
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
    public Page<Post> findAll(String search, Integer pageNo, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return postJpaRepository.findAll(search, pageRequest)
                .map(postDataAccessMapper::postEntityToPost);
    }

    @Override
    public Post findById(UUID postId) {
        return postDataAccessMapper
                .postEntityToPost(postJpaRepository
                        .findById(postId)
                        .orElseThrow(() -> new RuntimeException("Post not found")));
    }

    @Override
    public void deleteById(UUID postId) {
        PostEntity postEntity = postJpaRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        postJpaRepository.delete(postEntity);
    }
}
