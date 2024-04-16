package com.backend.programming.learning.system.core.service.domain.dto.query.review;

import com.backend.programming.learning.system.core.service.domain.dto.query.user.QueryUserResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryReviewResponse {
    @NotNull
    private final UUID reviewId;
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final String content;
    @NotNull
    private final Float rating;
    @NotNull
    private final QueryUserResponse createdBy;
    @NotNull
    private final QueryUserResponse updatedBy;
    @NotNull
    private final ZonedDateTime createdAt;
    @NotNull
    private final ZonedDateTime updatedAt;
}
