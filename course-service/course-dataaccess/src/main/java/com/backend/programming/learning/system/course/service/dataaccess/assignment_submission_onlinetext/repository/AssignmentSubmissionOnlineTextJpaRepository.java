package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_onlinetext.repository;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_onlinetext.entity.AssignmentSubmissionOnlineTextEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AssignmentSubmissionOnlineTextJpaRepository extends JpaRepository<AssignmentSubmissionOnlineTextEntity, UUID> {
    Optional<AssignmentSubmissionOnlineTextEntity> findById(UUID id);
}
