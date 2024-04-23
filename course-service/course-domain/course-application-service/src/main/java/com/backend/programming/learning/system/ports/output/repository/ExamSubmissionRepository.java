package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.ExamSubmission;

import java.util.UUID;

public interface ExamSubmissionRepository {
    ExamSubmission save(ExamSubmission examSubmission);

    ExamSubmission findBy(UUID examSubmissionId);
}
