package com.backend.programming.learning.system.core.service.domain.mapper.review;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryAllReviewsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.review.QueryReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.user.QueryUserResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ReviewDataMapper {
    private final UserDataMapper userDataMapper;

    public ReviewDataMapper(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }

    public Review createReviewCommandToReview(CreateReviewCommand createReviewCommand) {
        return Review.builder()
                .certificateCourseId(new CertificateCourseId(createReviewCommand.getCertificateCourseId()))
                .rating(createReviewCommand.getRating())
                .content(createReviewCommand.getContent())
                .createdBy(User
                        .builder()
                        .id(new UserId(createReviewCommand.getCreatedBy()))
                        .build())
                .updatedBy(User
                        .builder()
                        .id(new UserId(createReviewCommand.getUpdatedBy()))
                        .build())
                .build();
    }

    public CreateReviewResponse reviewToCreateReviewResponse(Review review, String message) {
        return CreateReviewResponse.builder()
                .reviewId(review.getId().getValue())
                .message(message)
                .build();
    }

    public QueryReviewResponse reviewToQueryReviewResponse(Review review) {
        QueryUserResponse createdByResponse = userDataMapper.userToQueryUserResponse(review.getCreatedBy());
        QueryUserResponse updatedByResponse = userDataMapper.userToQueryUserResponse(review.getUpdatedBy());

        return QueryReviewResponse.builder()
                .reviewId(review.getId().getValue())
                .certificateCourseId(review.getCertificateCourseId().getValue())
                .rating(review.getRating())
                .content(review.getContent())
                .createdBy(createdByResponse)
                .updatedBy(updatedByResponse)
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    public QueryAllReviewsResponse reviewsToQueryAllReviewsResponse(Page<Review> reviews) {
        return QueryAllReviewsResponse.builder()
                .reviews(reviews.map(this::reviewToQueryReviewResponse).getContent())
                .currentPage(reviews.getNumber())
                .totalItems(reviews.getTotalElements())
                .totalPages(reviews.getTotalPages())
                .build();
    }
}
