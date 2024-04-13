package com.backend.programming.learning.system.course.service.domain.dto.post.get;

import com.backend.programming.learning.system.course.service.domain.entity.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.post.get
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:14 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class PostResponse {
    private final List<Post> posts;
    private final String message;
}
