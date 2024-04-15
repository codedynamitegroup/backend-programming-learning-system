package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.AssignmentSubmission;

public interface SubmissionAssignmentRepository {
    AssignmentSubmission saveSubmissionAssignment(AssignmentSubmission submissionAssignment);
}
