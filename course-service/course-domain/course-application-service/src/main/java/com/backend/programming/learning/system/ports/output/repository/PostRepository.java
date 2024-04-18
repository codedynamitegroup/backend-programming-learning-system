package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Post;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface PostRepository {
    Post save(Post post);

    Page<Post> findAll(Integer pageNo, Integer pageSize);

    Post findById(UUID postId);
}
