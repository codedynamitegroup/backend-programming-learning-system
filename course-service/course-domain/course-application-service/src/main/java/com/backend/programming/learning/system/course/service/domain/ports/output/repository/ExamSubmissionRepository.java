package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.User;

import java.util.UUID;

public interface ExamSubmissionRepository {
    ExamSubmission save(ExamSubmission examSubmission);

    ExamSubmission findBy(UUID examSubmissionId);

    ExamSubmission findByExamAndUser(Exam exam, User user);
}
