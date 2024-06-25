package com.backend.programming.learning.system.core.service.domain.dto.method.query.review;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.review.ReviewResponseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryEachStarReviewCountResponse {
    @NotNull
    private final Integer numOfOneStarReviews;
    @NotNull
    private final Integer numOfTwoStarReviews;
    @NotNull
    private final Integer numOfThreeStarReviews;
    @NotNull
    private final Integer numOfFourStarReviews;
    @NotNull
    private final Integer numOfFiveStarReviews;
    @NotNull
    private final Integer numOfReviews;
    @NotNull
    private final Float avgRating;
}
