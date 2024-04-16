package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Post;

public interface PostRepository {
    Post savePost(Post post);
}
