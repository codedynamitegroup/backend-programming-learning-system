package com.backend.programming.learning.system.course.service.domain.ports.input.service.exam_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionResponse;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.ports.input.service.exam_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:30 AM
 * Description: ...
 */
public interface ExamSubmissionApplicationService {
    CreateExamSubmissionResponse submitExam(
            @Valid CreateExamSubmissionCommand createExamSubmissionCommand);

    CreateExamSubmissionResponse startExam(
            @Valid CreateExamSubmissionStartCommand createExamSubmissionStartCommand);

    CreateExamSubmissionResponse endExam(CreateExamSubmissionStartCommand createExamSubmissionStartCommand);

    QueryExamSubmissionResponse submitExamDetail(UUID submissionId);

    List<QueryExamSubmissionResponse> findByExamIdAndUserId(UUID examId, UUID userId);
}
