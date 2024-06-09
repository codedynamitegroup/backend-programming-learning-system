package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;

import java.util.List;
import java.util.UUID;

public interface ExamSubmissionRepository {
    ExamSubmission save(ExamSubmission examSubmission);

    ExamSubmission findBy(UUID examSubmissionId);

    ExamSubmission findByExamAndUser(Exam exam, User user);

    Integer countSubmission(ExamId examId);

    ExamSubmission saveEnd(CreateExamSubmissionStartCommand createExamSubmissionStartCommand);

    List<ExamSubmission> findByExamId(ExamId examId);

    List<ExamSubmission> findAllByExamIdAndUserId(UUID examId, UUID userId);
}
