package com.backend.programming.learning.system.course.service.dataaccess.repository.exam;

import com.backend.programming.learning.system.course.service.dataaccess.entity.exam.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.exam.repository
 * Create by Dang Ngoc Tien
 * Date 3/19/2024 - 11:20 PM
 * Description: ...
 */
@Repository
public interface ExamJpaRepository extends JpaRepository<ExamEntity, Long> {
}
