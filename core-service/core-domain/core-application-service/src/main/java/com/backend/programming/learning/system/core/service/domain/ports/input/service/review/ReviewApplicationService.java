package com.backend.programming.learning.system.core.service.domain.ports.input.service.review;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryReviewResponse;

import javax.validation.Valid;

public interface ReviewApplicationService {
    CreateReviewResponse createReview(
            @Valid CreateReviewCommand createReviewCommand);

    QueryAllReviewsResponse queryAllReviewsByCertificateCourseId(
            @Valid QueryAllReviewsCommand queryAllReviewsCommand);

    QueryReviewResponse queryReview(
            @Valid QueryReviewCommand queryReviewCommand);

    DeleteReviewResponse deleteReview(
            @Valid DeleteReviewCommand deleteReviewCommand);

}
