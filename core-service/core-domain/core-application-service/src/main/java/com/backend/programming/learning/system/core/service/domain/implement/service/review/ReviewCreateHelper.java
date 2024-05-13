package com.backend.programming.learning.system.core.service.domain.implement.service.review;

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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ReviewCreateHelper {
    private final CoreDomainService coreDomainService;
    private final ReviewRepository reviewRepository;
    private final CertificateCourseRepository certificateCourseRepository;
    private final CertificateCourseUserRepository certificateCourseUserRepository;
    private final ReviewDataMapper reviewDataMapper;

    public ReviewCreateHelper(CoreDomainService coreDomainService,
                              ReviewRepository reviewRepository,
                              CertificateCourseRepository certificateCourseRepository,
                              CertificateCourseUserRepository certificateCourseUserRepository,
                              ReviewDataMapper reviewDataMapper) {
        this.coreDomainService = coreDomainService;
        this.reviewRepository = reviewRepository;
        this.certificateCourseRepository = certificateCourseRepository;
        this.certificateCourseUserRepository = certificateCourseUserRepository;
        this.reviewDataMapper = reviewDataMapper;
    }

    @Transactional
    public Review persistReview(CreateReviewCommand createReviewCommand) {
        checkCertificateCourseUserByCertificateCourseIdAndUserId(
                createReviewCommand.getCertificateCourseId(),
                createReviewCommand.getCreatedBy());
        checkUserAlreadyReviewedCertificateCourse(
                createReviewCommand.getCertificateCourseId(),
                createReviewCommand.getCreatedBy());

        CertificateCourse certificateCourse = getCertificateCourse(createReviewCommand.getCertificateCourseId());

        Review review = reviewDataMapper.
                createReviewCommandToReview(createReviewCommand);
        coreDomainService.createReview(review);
        Review reviewResult = saveReview(review);

        Float avgRating = getAvgRatingOfAllReviewsByCertificateCourseId(
                createReviewCommand.getCertificateCourseId());

        updateAvgRating(certificateCourse, avgRating);

        log.info("Review created with id: {}", reviewResult.getId().getValue());
        return reviewResult;
    }

    private void checkUserAlreadyReviewedCertificateCourse(UUID certificateCourseId, UUID userId) {
        List<Review> reviews = reviewRepository.findByCertificateCourseIdAndCreatedById(certificateCourseId, userId);
        if (!reviews.isEmpty()) {
            log.error("User with id: {} has already reviewed certificate course with id: {}",
                    userId, certificateCourseId);
            throw new CoreDomainException("User with id: " + userId +
                    " has already reviewed certificate course with id: " + certificateCourseId);
        }
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


    private CertificateCourse getCertificateCourse(UUID certificateCourseId) {
        Optional<CertificateCourse> certificateCourse = certificateCourseRepository.findById(
                new CertificateCourseId(certificateCourseId));
        if (certificateCourse.isEmpty()) {
            log.warn("Certificate course with id: {} not found", certificateCourseId);
            throw new CertificateCourseNotFoundException("Could not find certificate course with id: " + certificateCourseId);
        }
        return certificateCourse.get();
    }

    private void updateAvgRating(CertificateCourse certificateCourse, Float avgRating) {
        certificateCourse.setAvgRating(avgRating);
        CertificateCourse updatedCertificateCourse =
                certificateCourseRepository.saveCertificateCourse(certificateCourse);

        if (updatedCertificateCourse == null) {
            log.error("Could not update avg rating for certificate course with id: {}",
                    certificateCourse.getId().getValue());
            throw new CoreDomainException("Could not update avg rating for certificate course with id: "
                    + certificateCourse.getId().getValue());
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





















