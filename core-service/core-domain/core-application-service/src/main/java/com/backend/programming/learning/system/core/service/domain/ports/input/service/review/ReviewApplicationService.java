package com.backend.programming.learning.system.core.service.domain.ports.input.service.review;

import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;

import javax.validation.Valid;

public interface ReviewApplicationService {
    CreateReviewResponse createReview(
            @Valid CreateReviewCommand createReviewCommand);

}
