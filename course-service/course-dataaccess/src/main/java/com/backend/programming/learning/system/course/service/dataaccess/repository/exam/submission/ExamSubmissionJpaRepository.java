package com.backend.programming.learning.system.course.service.dataaccess.repository.exam.submission;

import com.backend.programming.learning.system.course.service.dataaccess.entity.exam.submission.ExamSubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.repository.exam.submission
 * Create by Dang Ngoc Tien
 * Date 4/15/2024 - 12:03 AM
 * Description: ...
 */
@Repository
public interface ExamSubmissionJpaRepository extends JpaRepository<ExamSubmissionEntity, Long> {
}
