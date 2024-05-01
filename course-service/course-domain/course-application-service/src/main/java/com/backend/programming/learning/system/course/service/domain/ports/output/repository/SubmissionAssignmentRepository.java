package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubmissionAssignmentRepository {
    SubmissionAssignment saveSubmissionAssignment(SubmissionAssignment submissionAssignment);

    Optional<SubmissionAssignment> findById(UUID submissionAssignmentId);

    List<SubmissionAssignment> findAllByAssignmentId(AssignmentId assignmentId);

    void deleteSubmissionAssignmentById(UUID submissionAssignmentId);

}
