package com.backend.programming.learning.system.course.service.domain.dto.method.update.post;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UpdatePostResponse(
        UUID id,
        String message
) {
}
