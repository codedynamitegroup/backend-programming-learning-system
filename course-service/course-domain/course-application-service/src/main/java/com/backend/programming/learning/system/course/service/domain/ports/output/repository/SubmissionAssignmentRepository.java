package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentId;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubmissionAssignmentRepository {
    SubmissionAssignment saveSubmissionAssignment(SubmissionAssignment submissionAssignment);

    Optional<SubmissionAssignment> findById(UUID submissionAssignmentId);

    Page<SubmissionAssignment> findAllByAssignmentId(UUID assignmentId, String search, Boolean isGraded, Integer page, Integer size);

    void deleteSubmissionAssignmentById(UUID submissionAssignmentId);

    SubmissionAssignment findByAssignmentIdAndUserId(UUID assignmentId, UUID userId);

    SubmissionAssignment update(SubmissionAssignment submissionAssignment);


    Integer countSubmissionsToGradeByAssignmentId(UUID assignmentId);

    Integer countAllByAssignmentId(UUID assignmentId);
}
