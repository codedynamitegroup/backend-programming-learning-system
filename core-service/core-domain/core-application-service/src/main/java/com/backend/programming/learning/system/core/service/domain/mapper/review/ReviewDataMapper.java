package com.backend.programming.learning.system.core.service.domain.mapper.review;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class ReviewDataMapper {
    private final UserRepository userRepository;

    public ReviewDataMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Review createReviewCommandToReview(CreateReviewCommand createReviewCommand) {
        User createdBy = userRepository.findUser(new UserId(createReviewCommand.getCreatedBy()).getValue())
                .orElseThrow(() -> new TopicNotFoundException("User not found with id: " +
                        createReviewCommand.getCreatedBy()));
        User updatedBy = userRepository.findUser(new UserId(createReviewCommand.getUpdatedBy()).getValue())
                .orElseThrow(() -> new TopicNotFoundException("User not found with id: " +
                        createReviewCommand.getUpdatedBy()));
        return Review.builder()
                .certificateCourseId(new CertificateCourseId(createReviewCommand.getCertificateCourseId()))
                .rating(createReviewCommand.getRating())
                .content(createReviewCommand.getContent())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .build();
    }

    public CreateReviewResponse reviewToCreateReviewResponse(Review review, String message) {
        return CreateReviewResponse.builder()
                .review(review)
                .message(message)
                .build();
    }
}
