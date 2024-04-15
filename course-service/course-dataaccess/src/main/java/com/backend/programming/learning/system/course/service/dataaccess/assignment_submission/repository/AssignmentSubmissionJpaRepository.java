package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.repository;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.AssignmentSubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository

public interface AssignmentSubmissionJpaRepository extends JpaRepository<AssignmentSubmissionEntity, UUID> {
    Optional<AssignmentSubmissionEntity> findById(UUID id);
}
