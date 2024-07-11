package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.repository;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.entity.SubmissionAssignmentFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubmissionAssignmentFileJpaRepository extends JpaRepository<SubmissionAssignmentFileEntity, UUID> {
    Optional<SubmissionAssignmentFileEntity> findById(UUID id);

    List<SubmissionAssignmentFileEntity> findBySubmissionAssignmentId(UUID submissionAssignmentId);

    Optional<SubmissionAssignmentFileEntity> findBySubmissionAssignmentIdAndFileName(UUID submissionAssignmentId, String fileName);
}
