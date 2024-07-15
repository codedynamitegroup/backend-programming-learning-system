package com.backend.programming.learning.system.course.service.dataaccess.post.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.post.entity.PostEntity;
import com.backend.programming.learning.system.course.service.dataaccess.post.mapper.PostDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.post.repository.PostJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.Post;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
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
    public Page<Post> findAllByCourseId(UUID courseId, Integer pageNo, Integer pageSize) {
        Pageable pageRequest = PageRequest.of(pageNo, pageSize);
        return postJpaRepository.findAllByCourseId(courseId, pageRequest)
                .map(postDataAccessMapper::postEntityToPost);
    }

    @Override
    public Optional<Post> findById(UUID postId) {
        return postJpaRepository.findById(postId)
                .map(postDataAccessMapper::postEntityToPost);
    }

    @Override
    public void deleteById(UUID postId) {
        PostEntity postEntity = postJpaRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        postJpaRepository.delete(postEntity);
    }
}
