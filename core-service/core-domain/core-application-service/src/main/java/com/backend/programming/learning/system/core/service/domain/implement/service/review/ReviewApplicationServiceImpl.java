package com.backend.programming.learning.system.core.service.domain.implement.service.review;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.review.DeleteReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryEachStarReviewCountResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.review.ReviewResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.review.ReviewApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

import java.util.UUID;

@Service
@Validated
@Slf4j
class ReviewApplicationServiceImpl implements ReviewApplicationService {
    private final ReviewCommandHandler reviewCommandHandler;

    public ReviewApplicationServiceImpl(ReviewCommandHandler reviewCommandHandler) {
        this.reviewCommandHandler = reviewCommandHandler;
    }

    @Override
    public CreateReviewResponse createReview(@Valid CreateReviewCommand createReviewCommand) {
        return reviewCommandHandler.createReviewResponse(createReviewCommand);
    }

    @Override
    public QueryAllReviewsResponse queryAllReviewsByCertificateCourseId(QueryAllReviewsCommand queryAllReviewsCommand) {
        return reviewCommandHandler.findAllReviewsResponse(queryAllReviewsCommand);
    }

    @Override
    public ReviewResponseEntity queryReview(QueryReviewCommand queryReviewCommand) {
        return reviewCommandHandler.findReviewResponseById(queryReviewCommand);
    }

    @Override
    public DeleteReviewResponse deleteReview(DeleteReviewCommand deleteReviewCommand) {
        return reviewCommandHandler.deleteReviewResponse(deleteReviewCommand);
    }

    @Override
    public UpdateReviewResponse updateReview(UpdateReviewCommand updateReviewCommand) {
        return reviewCommandHandler.updateReviewResponse(updateReviewCommand);
    }

    @Override
    public QueryEachStarReviewCountResponse queryEachStarReviewCountByCertificateCourseId(UUID certificateCourseId) {
        return reviewCommandHandler.findEachStarReviewCountResponse(certificateCourseId);
    }
}
