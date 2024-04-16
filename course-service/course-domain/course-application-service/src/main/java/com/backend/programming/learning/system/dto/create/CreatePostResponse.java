package com.backend.programming.learning.system.dto.create;

import com.backend.programming.learning.system.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.post.create
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:14 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class CreatePostResponse {
    private final Post post;
    private final String message;
}
