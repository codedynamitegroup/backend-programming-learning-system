package com.backend.programming.learning.system.course.service.dataaccess.course_type.repository;

import com.backend.programming.learning.system.course.service.dataaccess.course_type.entity.CourseTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseTypeJpaRepository extends JpaRepository<CourseTypeEntity, UUID> {
    Optional<CourseTypeEntity> findById(UUID id);

     Optional<CourseTypeEntity> findByName(String courseName);

     @Query("""
             SELECT cte
             FROM CourseTypeEntity cte
             WHERE cte.name LIKE %:search%
             """)
    Page<CourseTypeEntity> findAll(String search, Pageable pageable);
    Optional<CourseTypeEntity> findByMoodleIdAndOrganizationId(Integer moodleId,UUID organizationId);

    @Query("""
             SELECT cte
             FROM CourseTypeEntity cte
             WHERE cte.organization.id = :organizationId
             AND cte.name LIKE %:searchName%
             """)
    Page<CourseTypeEntity> findAllByOrganizationId(UUID organizationId, Pageable pageable, String searchName);
}
