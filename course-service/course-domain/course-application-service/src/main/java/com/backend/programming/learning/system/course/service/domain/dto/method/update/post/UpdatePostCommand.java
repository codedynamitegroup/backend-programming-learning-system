package com.backend.programming.learning.system.course.service.domain.dto.method.update.post;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UpdatePostCommand(
        @NotNull(message = "Post id is required")
        UUID postId,
        String title,
        String content
) {
}
