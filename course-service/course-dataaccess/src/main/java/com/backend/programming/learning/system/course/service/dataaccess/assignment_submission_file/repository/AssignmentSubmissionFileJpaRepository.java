package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.repository;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.entity.AssignmentSubmissionFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AssignmentSubmissionFileJpaRepository extends JpaRepository<AssignmentSubmissionFileEntity, UUID> {
    Optional<AssignmentSubmissionFileEntity> findById(UUID id);

    Optional<AssignmentSubmissionFileEntity> findByAssignmentSubmission_Id(UUID submissionAssignmentId);}
