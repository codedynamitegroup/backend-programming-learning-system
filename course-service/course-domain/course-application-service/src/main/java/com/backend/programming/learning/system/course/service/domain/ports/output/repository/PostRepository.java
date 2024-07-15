package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.Post;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface PostRepository {
    Post save(Post post);

    Page<Post> findAllByCourseId(UUID courseId, Integer pageNo, Integer pageSize);

    Post findById(UUID postId);

    void deleteById(UUID postId);
}
