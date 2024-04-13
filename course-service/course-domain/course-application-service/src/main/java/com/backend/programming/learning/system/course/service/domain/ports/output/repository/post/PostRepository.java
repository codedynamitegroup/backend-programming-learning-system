package com.backend.programming.learning.system.course.service.domain.ports.output.repository.post;

import com.backend.programming.learning.system.course.service.domain.entity.post.Post;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.ports.output.repository.post
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:16 AM
 * Description: ...
 */
public interface PostRepository {
    Post createPost(Post post);

    List<Post> findAll(String search);

    Post getPost(Long postId);

    void deletePost(Long postId);
}
