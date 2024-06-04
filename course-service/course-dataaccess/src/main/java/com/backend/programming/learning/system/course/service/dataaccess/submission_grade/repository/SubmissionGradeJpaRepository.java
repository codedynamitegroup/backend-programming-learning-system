package com.backend.programming.learning.system.course.service.dataaccess.submission_grade.repository;

import com.backend.programming.learning.system.course.service.dataaccess.submission_grade.entity.SubmissionGradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubmissionGradeJpaRepository extends JpaRepository<SubmissionGradeEntity, UUID>{
    Optional<SubmissionGradeEntity> findById(UUID id);

    Optional<SubmissionGradeEntity> findBySubmissionAssignmentId(UUID submissionId);

}
