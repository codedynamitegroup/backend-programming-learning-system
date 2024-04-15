package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.AssignmentSubmissionFile;

public interface SubmissionAssignmentFileRepository {
    AssignmentSubmissionFile saveAssignmentSubmissionFile(AssignmentSubmissionFile assignmentSubmissionFile);
}
