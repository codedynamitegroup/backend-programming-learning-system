package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.SubmissionFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubmissionFileRepository {
    Optional<SubmissionFile> findById(UUID submissionFileId);

    SubmissionFile save(SubmissionFile submissionFile);

    void deleteById(UUID submissionFileId);

    List<SubmissionFile> findBySubmissionAssignmentFileId(UUID submissionAssignmentFileId);
}
