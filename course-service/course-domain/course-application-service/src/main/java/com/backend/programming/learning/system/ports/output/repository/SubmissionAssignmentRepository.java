package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.SubmissionAssignment;
import com.backend.programming.learning.system.entity.SubmissionAssignmentOnlineText;
import com.backend.programming.learning.system.valueobject.AssignmentId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubmissionAssignmentRepository {
    SubmissionAssignment saveSubmissionAssignment(SubmissionAssignment submissionAssignment);

    Optional<SubmissionAssignment> findById(UUID submissionAssignmentId);

    List<SubmissionAssignment> findAllByAssignmentId(AssignmentId assignmentId);

    void deleteSubmissionAssignmentById(UUID submissionAssignmentId);

}
