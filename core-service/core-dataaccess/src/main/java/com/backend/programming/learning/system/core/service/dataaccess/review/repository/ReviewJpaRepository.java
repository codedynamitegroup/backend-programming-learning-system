package com.backend.programming.learning.system.core.service.dataaccess.review.repository;

import com.backend.programming.learning.system.core.service.dataaccess.review.entity.ReviewEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewJpaRepository extends PagingAndSortingRepository<ReviewEntity, UUID> {
    Optional<ReviewEntity> findById(UUID id);
    Page<ReviewEntity> findAllByCertificateCourseId(UUID certificateCourseId, Pageable pageable);

}
