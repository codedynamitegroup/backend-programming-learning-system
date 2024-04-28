package com.backend.programming.learning.system.core.service.domain.implement.service.review;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ReviewNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ReviewQueryHelper {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public ReviewQueryHelper(ReviewRepository reviewRepository,
                             UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Review queryReviewById(UUID reviewId) {
        Optional<Review> reviewResult =
                reviewRepository.findById(reviewId);
        if (reviewResult.isEmpty()) {
            log.warn("Could not find review with id: {}",
                    reviewId);
            throw new ReviewNotFoundException("Could not find review with id: " +
                    reviewId);
        }
        User createdBy = getUser(reviewResult.get().getCreatedBy().getId().getValue());
        User updatedBy = getUser(reviewResult.get().getUpdatedBy().getId().getValue());

        Review review = reviewResult.get();
        review.setCreatedBy(createdBy);
        review.setUpdatedBy(updatedBy);

        log.info("Review queried with id: {}", review.getId().getValue());
        return review;
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }


    @Transactional(readOnly = true)
    public Page<Review> queryAllReviewsByCertificateCourseId(
            UUID certificateCourseId, Integer pageNo, Integer pageSize
    ) {
        return reviewRepository.findAllByCertificateCourseId(certificateCourseId, pageNo, pageSize);
    }

}





















