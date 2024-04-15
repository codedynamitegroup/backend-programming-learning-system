package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.ExamSubmission;

public interface ExamSubmissionRepository {
    ExamSubmission saveExamSubmission(ExamSubmission examSubmission);
}
