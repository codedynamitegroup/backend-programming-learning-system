package com.backend.programming.learning.system.core.service.domain.ports.input.service.review;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.review.ReviewResponseEntity;

import jakarta.validation.Valid;

public interface ReviewApplicationService {
    CreateReviewResponse createReview(
            @Valid CreateReviewCommand createReviewCommand);

    QueryAllReviewsResponse queryAllReviewsByCertificateCourseId(
            @Valid QueryAllReviewsCommand queryAllReviewsCommand);

    ReviewResponseEntity queryReview(
            @Valid QueryReviewCommand queryReviewCommand);

    DeleteReviewResponse deleteReview(
            @Valid DeleteReviewCommand deleteReviewCommand);

    UpdateReviewResponse updateReview(
            @Valid UpdateReviewCommand updateReviewCommand);

}
