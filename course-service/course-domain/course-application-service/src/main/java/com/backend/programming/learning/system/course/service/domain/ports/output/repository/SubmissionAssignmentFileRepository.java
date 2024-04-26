package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;

public interface SubmissionAssignmentFileRepository {
    SubmissionAssignmentFile saveSubmissionAssignmentFile(SubmissionAssignmentFile submissionAssignmentFile);
}
