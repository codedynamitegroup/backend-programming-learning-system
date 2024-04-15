package com.backend.programming.learning.system.core.service.domain.dto.query.review;

import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class QueryReviewResponse {
    @NotNull
    private final Review review;
    @NotNull
    private final String message;
}
