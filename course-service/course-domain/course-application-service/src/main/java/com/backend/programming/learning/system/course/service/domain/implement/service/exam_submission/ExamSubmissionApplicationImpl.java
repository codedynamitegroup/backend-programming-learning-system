package com.backend.programming.learning.system.course.service.domain.implement.service.exam_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.exam_submission.ExamSubmissionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implement.exam_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:25 AM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class ExamSubmissionApplicationImpl implements ExamSubmissionApplicationService {
    private final ExamSubmissionCommandHandler examSubmissionCommandHandler;
    @Override
    public CreateExamSubmissionResponse submitExam(CreateExamSubmissionCommand createExamSubmissionCommand) {
        return examSubmissionCommandHandler.submitExam(createExamSubmissionCommand);
    }

    @Override
    public CreateExamSubmissionResponse startExam(CreateExamSubmissionStartCommand createExamSubmissionCommand) {
        return examSubmissionCommandHandler.startExam(createExamSubmissionCommand);
    }

    @Override
    public CreateExamSubmissionResponse endExam(CreateExamSubmissionStartCommand createExamSubmissionStartCommand) {
        return examSubmissionCommandHandler.endExam(createExamSubmissionStartCommand);
    }

    @Override
    public QueryExamSubmissionResponse submitExamDetail(UUID submissionId) {
        return examSubmissionCommandHandler.submitExamDetail(submissionId);
    }

    @Override
    public List<QueryExamSubmissionOverviewResponse> findByExamIdAndUserId(UUID examId, UUID userId) {
        return examSubmissionCommandHandler.findByExamIdAndUserId(examId, userId);
    }
}
