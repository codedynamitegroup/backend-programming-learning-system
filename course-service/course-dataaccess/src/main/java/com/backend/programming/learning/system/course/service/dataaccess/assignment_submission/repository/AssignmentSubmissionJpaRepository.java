package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.repository;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.SubmissionAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository

public interface AssignmentSubmissionJpaRepository extends JpaRepository<SubmissionAssignmentEntity, UUID> {
    Optional<SubmissionAssignmentEntity> findById(UUID id);

    List<SubmissionAssignmentEntity> findAllByAssignmentId(UUID assignmentId);
}
