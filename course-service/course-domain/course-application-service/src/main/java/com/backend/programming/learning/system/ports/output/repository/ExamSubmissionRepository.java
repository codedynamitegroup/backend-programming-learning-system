package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.entity.ExamSubmission;
import com.backend.programming.learning.system.entity.User;

import java.util.List;
import java.util.UUID;

public interface ExamSubmissionRepository {
    ExamSubmission save(ExamSubmission examSubmission);

    ExamSubmission findBy(UUID examSubmissionId);

    ExamSubmission findByExamAndUser(Exam exam, User user);
}
