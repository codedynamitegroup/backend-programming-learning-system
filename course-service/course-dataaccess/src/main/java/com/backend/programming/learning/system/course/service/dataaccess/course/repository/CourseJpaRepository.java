package com.backend.programming.learning.system.course.service.dataaccess.course.repository;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseJpaRepository extends JpaRepository<CourseEntity, UUID> {
    Optional<CourseEntity> findById(UUID id);

     Optional<CourseEntity> findByName(String courseName);
}
