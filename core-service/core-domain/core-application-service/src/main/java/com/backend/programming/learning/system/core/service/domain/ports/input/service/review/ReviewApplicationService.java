package com.backend.programming.learning.system.core.service.domain.ports.input.service.review;

import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.review.DeleteReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.review.DeleteReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.review.QueryAllReviewsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.review.QueryAllReviewsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.review.QueryReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.review.QueryReviewResponse;

import javax.validation.Valid;

public interface ReviewApplicationService {
    CreateReviewResponse createReview(
            @Valid CreateReviewCommand createReviewCommand);

    QueryAllReviewsResponse queryAllReviews(
            @Valid QueryAllReviewsCommand queryAllReviewsCommand);

    QueryReviewResponse queryReview(
            @Valid QueryReviewCommand queryReviewCommand);

    DeleteReviewResponse deleteReview(
            @Valid DeleteReviewCommand deleteReviewCommand);

}
