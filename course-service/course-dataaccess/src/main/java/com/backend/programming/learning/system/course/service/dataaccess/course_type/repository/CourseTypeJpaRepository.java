package com.backend.programming.learning.system.course.service.dataaccess.course_type.repository;

import com.backend.programming.learning.system.course.service.dataaccess.course_type.entity.CourseTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseTypeJpaRepository extends JpaRepository<CourseTypeEntity, UUID> {
    Optional<CourseTypeEntity> findById(UUID id);

     Optional<CourseTypeEntity> findByName(String courseName);

     @Query("""
             SELECT c
             FROM CourseEntity c
             WHERE c.name LIKE %:search%
             """)
    Page<CourseTypeEntity> findAll(String search, Pageable pageable);

}
