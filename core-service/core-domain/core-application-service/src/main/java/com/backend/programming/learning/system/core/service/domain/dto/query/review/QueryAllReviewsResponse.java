package com.backend.programming.learning.system.core.service.domain.dto.query.review;

import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryChapterResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllReviewsResponse {
    @NotNull
    private final List<QueryReviewResponse> reviews;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
