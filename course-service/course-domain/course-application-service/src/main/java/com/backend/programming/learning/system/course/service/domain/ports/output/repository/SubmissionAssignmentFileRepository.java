package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubmissionAssignmentFileRepository {
    SubmissionAssignmentFile saveSubmissionAssignmentFile(SubmissionAssignmentFile submissionAssignmentFile);

    List<SubmissionAssignmentFile> findBySubmissionAssignmentId(UUID submissionAssignmentId);
}
