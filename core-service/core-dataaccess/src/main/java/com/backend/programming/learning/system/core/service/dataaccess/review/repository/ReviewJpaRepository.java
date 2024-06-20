package com.backend.programming.learning.system.core.service.dataaccess.review.repository;

import com.backend.programming.learning.system.core.service.dataaccess.review.entity.ReviewEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewJpaRepository extends JpaRepository<ReviewEntity, UUID> {
    Optional<ReviewEntity> findById(UUID id);
    Page<ReviewEntity> findAllByCertificateCourseId(UUID certificateCourseId, Pageable pageable);

    @Transactional(readOnly = true)
    @Query("SELECT AVG(r.rating) FROM ReviewEntity r WHERE r.certificateCourse.id = :certificateCourseId")
    Float getAvgRatingOfAllReviewsByCertificateCourseId(UUID certificateCourseId);

    List<ReviewEntity> findByCertificateCourseIdAndCreatedById(UUID certificateCourseId, UUID createdBy);

    @Query(value= """
            SELECT * FROM review r
            WHERE r.certificate_course_id = ?1
            AND r.created_by = ?2
            LIMIT 1
""", nativeQuery = true)
    Optional<ReviewEntity> findByCertificateCourseIdAndCreatedBy(UUID certificateCourseId, UUID createdBy);
}
