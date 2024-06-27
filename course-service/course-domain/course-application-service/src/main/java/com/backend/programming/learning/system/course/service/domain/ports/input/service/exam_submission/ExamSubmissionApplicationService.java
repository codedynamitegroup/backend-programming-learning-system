package com.backend.programming.learning.system.course.service.domain.ports.input.service.exam_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionEndCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryAllStudentExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryAllStudentExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamSubmissionId;
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

    CreateExamSubmissionResponse endExam(CreateExamSubmissionEndCommand createExamSubmissionEndCommand);

    QueryExamSubmissionResponse submitExamDetail(UUID submissionId);

    List<QueryExamSubmissionOverviewResponse> findByExamIdAndUserId(UUID examId, UUID userId);

    QueryExamSubmissionOverviewResponse findLatestOnGoingSubmission(UUID examId, UUID userId);

    QueryAllStudentExamSubmissionResponse findByExamId(
            @Valid ExamId examId,
            @Valid QueryAllStudentExamSubmissionCommand queryAllStudentExamSubmissionCommand);

    void updateStatusGrade(ExamSubmissionId examSubmissionId);
}
