package com.backend.programming.learning.system.core.service.domain.implement.review;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.review.ReviewDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseUserRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ReviewCreateHelper {
    private final CoreDomainService coreDomainService;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final CertificateCourseRepository certificateCourseRepository;
    private final CertificateCourseUserRepository certificateCourseUserRepository;
    private final ReviewDataMapper reviewDataMapper;

    public ReviewCreateHelper(CoreDomainService coreDomainService,
                              ReviewRepository reviewRepository,
                              UserRepository userRepository,
                              CertificateCourseRepository certificateCourseRepository,
                              CertificateCourseUserRepository certificateCourseUserRepository,
                              ReviewDataMapper reviewDataMapper) {
        this.coreDomainService = coreDomainService;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.certificateCourseRepository = certificateCourseRepository;
        this.certificateCourseUserRepository = certificateCourseUserRepository;
        this.reviewDataMapper = reviewDataMapper;
    }

    @Transactional
    public Review persistReview(CreateReviewCommand createReviewCommand) {
        checkUser(createReviewCommand.getCreatedBy());
        checkUser(createReviewCommand.getUpdatedBy());
        checkCertificateCourse(createReviewCommand.getCertificateCourseId());
        checkCertificateCourseUserByCertificateCourseIdAndUserId(
                createReviewCommand.getCertificateCourseId(),
                createReviewCommand.getCreatedBy());

        Review review = reviewDataMapper.
                createReviewCommandToReview(createReviewCommand);
        coreDomainService.createReview(review);
        Review reviewResult = saveReview(review);

        Float avgRating = getAvgRatingOfAllReviewsByCertificateCourseId(
                createReviewCommand.getCertificateCourseId());
        int updatedRows = certificateCourseRepository.updateAvgRating(
                new CertificateCourseId(createReviewCommand.getCertificateCourseId()), avgRating);
        if (updatedRows == 0) {
            log.error("Could not update avg rating for certificate course with id: {}",
                    createReviewCommand.getCertificateCourseId());
            throw new CoreDomainException("Could not update avg rating for certificate course with id: " +
                    createReviewCommand.getCertificateCourseId());
        }

        log.info("Review created with id: {}", reviewResult.getId().getValue());
        return reviewResult;
    }

    private void checkCertificateCourseUserByCertificateCourseIdAndUserId(
            UUID certificateCourseId, UUID userId) {
        Optional<CertificateCourseUser> certificateCourseUser = certificateCourseUserRepository
                .findByCertificateCourseIdAndUserId(certificateCourseId, userId);
        if (certificateCourseUser.isEmpty()) {
            log.error("User with id: {} is not registered for certificate course with id: {}",
                    userId, certificateCourseId);
            throw new CoreDomainException("User with id: " + userId +
                    " is not registered for certificate course with id: " + certificateCourseId);
        }
    }

    private Float getAvgRatingOfAllReviewsByCertificateCourseId(UUID certificateCourseId) {
        return reviewRepository.getAvgRatingOfAllReviewsByCertificateCourseId(certificateCourseId);
    }

    private void checkUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
    }

    private void checkCertificateCourse(UUID certificateCourseId) {
        Optional<CertificateCourse> certificateCourse = certificateCourseRepository.findById(
                new CertificateCourseId(certificateCourseId)
        );
        if (certificateCourse.isEmpty()) {
            log.warn("Certificate course with id: {} not found", certificateCourseId);
            throw new CertificateCourseNotFoundException(
                    "Could not find certificate course with id: " + certificateCourseId);
        }
    }

    private Review saveReview(Review review) {
        Review savedReview = reviewRepository
                .saveReview(review);

        if (savedReview == null) {
            log.error("Could not save review");

            throw new CoreDomainException("Could not save review");
        }
        log.info("Review saved with id: {}", savedReview.getId().getValue());
        return savedReview;
    }
}





















