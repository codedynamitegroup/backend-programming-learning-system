package com.backend.programming.learning.system.core.service.domain.dto.method.delete.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteReviewResponse {
    @NotNull
    private final UUID reviewId;
    @NotNull
    private final String message;
}
