package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.SubmissionGrade;

import java.util.Optional;
import java.util.UUID;

public interface SubmissionGradeRepository {
    SubmissionGrade save(SubmissionGrade submissionGrade);

    Optional<SubmissionGrade> findById(UUID submissionGradeId);

    Optional<SubmissionGrade> findBySubmissionAssignmentId(UUID submissionId);
}
