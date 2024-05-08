package com.backend.programming.learning.system.core.service.domain.dto.method.query.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryReviewCommand {
    @NotNull
    private final UUID reviewId;
}
