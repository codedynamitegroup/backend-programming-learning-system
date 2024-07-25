package com.backend.programming.learning.system.course.service.dataaccess.course.repository;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseJpaRepository extends JpaRepository<CourseEntity, UUID> {
    Optional<CourseEntity> findById(UUID id);

     Optional<CourseEntity> findByName(String courseName);

    @Query("""
    SELECT c
    FROM CourseEntity c
    WHERE c.name LIKE %:search%
    AND (:courseType IS NULL OR c.courseType.id IN :courseType)
    """)
    Page<CourseEntity> findAll(String search,String[] courseType, Pageable pageable);

    Optional<CourseEntity> findByCourseIdMoodleAndOrganizationId(Integer courseIdMoodle,UUID organizationId);

    @Query("""
    SELECT c
    FROM CourseEntity c
    WHERE c.organization.id = :organizationId
    AND c.name LIKE %:search%
    AND (:courseType IS NULL OR c.courseType.id IN :courseType)
    """)
    Page<CourseEntity> findAllByOrganizationId(UUID organizationId,String search,String[] courseType, Pageable pageable);

    void deleteByCourseIdMoodle(Integer courseIdMoodle);
}
