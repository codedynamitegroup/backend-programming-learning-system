package com.backend.programming.learning.system.core.service.domain.mapper.review;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class ReviewDataMapper {
    public Review createReviewCommandToReview(CreateReviewCommand createReviewCommand) {
        return Review.builder()
                .certificateCourseId(new CertificateCourseId(createReviewCommand.getCertificateCourseId()))
                .rating(createReviewCommand.getRating())
                .content(createReviewCommand.getContent())
                .createdBy(new UserId(createReviewCommand.getCreatedBy()))
                .updatedBy(new UserId(createReviewCommand.getUpdatedBy()))
                .build();
    }

    public CreateReviewResponse reviewToCreateReviewResponse(Review review, String message) {
        return CreateReviewResponse.builder()
                .review(review)
                .message(message)
                .build();
    }
}
