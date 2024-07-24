package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionEndCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamSubmissionId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExamSubmissionRepository {
    ExamSubmission save(ExamSubmission examSubmission);

    ExamSubmission findBy(UUID examSubmissionId);

    // Find latest submission of user for exam (min count)
    ExamSubmission findByExamAndUser(Exam exam, User user);

    Integer countSubmission(ExamId examId);

    ExamSubmission saveEnd(CreateExamSubmissionEndCommand createExamSubmissionStartCommand);

    List<ExamSubmission> findByExamId(ExamId examId);

    List<ExamSubmission> findAllByExamIdAndUserId(UUID examId, UUID userId);

    Optional<ExamSubmission> findLatestExamSubmissionByExamIdAndUserId(UUID examId, UUID userId);

    List<ExamSubmission> findByCourseIdAndUserId(UUID courseId, UUID userId, String searchName);

    void updateExamSubmissionScore(ExamSubmissionId id, Float grade);

    Optional<ExamSubmission> findFirstExamSubmissionByExamIdAndUserId(UUID examId, UUID userId);
}
