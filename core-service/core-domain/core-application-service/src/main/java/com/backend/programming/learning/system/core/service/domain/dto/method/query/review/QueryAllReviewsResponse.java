package com.backend.programming.learning.system.core.service.domain.dto.method.query.review;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.review.ReviewResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllReviewsResponse {
    @NotNull
    private final List<ReviewResponseEntity> reviews;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
