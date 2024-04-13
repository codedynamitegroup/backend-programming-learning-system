package com.backend.programming.learning.system.course.service.dataaccess.repository.course;

import com.backend.programming.learning.system.course.service.dataaccess.entity.course.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.repository.course
 * Create by Dang Ngoc Tien
 * Date 4/11/2024 - 12:42 AM
 * Description: ...
 */
@Repository
public interface CourseJpaRepository extends JpaRepository<CourseEntity, Long> {
}
