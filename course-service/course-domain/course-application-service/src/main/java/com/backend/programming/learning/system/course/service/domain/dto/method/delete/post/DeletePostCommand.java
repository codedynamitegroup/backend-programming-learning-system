package com.backend.programming.learning.system.course.service.domain.dto.method.delete.post;

import lombok.Builder;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.delete.post
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 11:26 AM
 * Description: ...
 */
@Builder
public record DeletePostCommand(
        @NotNull(message = "Post id is required")
        UUID postId
) {
}
