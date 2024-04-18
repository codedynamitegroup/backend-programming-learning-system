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
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewJpaRepository extends PagingAndSortingRepository<ReviewEntity, UUID> {
    Optional<ReviewEntity> findById(UUID id);
    Page<ReviewEntity> findAllByCertificateCourseId(UUID certificateCourseId, Pageable pageable);

    @Transactional(readOnly = true)
    @Query("SELECT AVG(r.rating) FROM ReviewEntity r WHERE r.certificateCourse.id = :certificateCourseId")
    Float getAvgRatingOfAllReviewsByCertificateCourseId(UUID certificateCourseId);

    @Transactional
    @Modifying
    @Query("update ReviewEntity r set r.rating = ?1, r.content = ?2, r.updatedAt = ?3 where r.id = ?4")
    int updateReviewById(Float rating, String content, ZonedDateTime updatedAt, UUID id);
}
