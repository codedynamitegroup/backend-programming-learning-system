package com.backend.programming.learning.system.course.service.dataaccess.course_user.repository;

import com.backend.programming.learning.system.course.service.dataaccess.course_user.entity.CourseUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CourseUserJpaRepository extends JpaRepository<CourseUserEntity, UUID> {
    Optional<CourseUserEntity> findById(UUID id);
}
