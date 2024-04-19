package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
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
public interface CertificateCourseJpaRepository extends PagingAndSortingRepository<CertificateCourseEntity, UUID> {
    Optional<CertificateCourseEntity> findById(UUID id);
    Optional<CertificateCourseEntity> findByName(String name);
    Page<CertificateCourseEntity> findAllByIsDeletedFalse(Pageable pageable);

    @Transactional
    @Modifying
    @Query("update CertificateCourseEntity c set c.isDeleted = ?1 where c.id = ?2")
    int deleteById(Boolean isDeleted, UUID id);

    @Transactional
    @Modifying
    @Query("update CertificateCourseEntity c set c.avgRating = ?1 where c.id = ?2")
    int updateAvgRating(Float avgRating, UUID id);
}
