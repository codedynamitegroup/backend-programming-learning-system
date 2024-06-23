package com.backend.programming.learning.system.course.service.domain.implement.service.exam_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionEndCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.mapper.exam_submission.ExamSubmissionDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implement.exam_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:26 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamSubmissionCommandHandler {
    private final ExamSubmissionCreateHelper examSubmissionCreateHelper;
    private final ExamSubmissionQueryHelper examSubmissionQueryHelper;
    private final ExamSubmissionDataMapper examSubmissionDataMapper;
    @Transactional
    public CreateExamSubmissionResponse submitExam(CreateExamSubmissionCommand createExamSubmissionCommand) {
        ExamSubmission examSubmission = examSubmissionCreateHelper.createExamSubmission(createExamSubmissionCommand);
        return examSubmissionDataMapper.mapToCreateExamSubmissionResponse(examSubmission);
    }

    @Transactional
    public CreateExamSubmissionResponse startExam(CreateExamSubmissionStartCommand createExamSubmissionStartCommand) {
        ExamSubmission examSubmission = examSubmissionCreateHelper.createStartExamSubmission(createExamSubmissionStartCommand);
        return examSubmissionDataMapper.mapToCreateExamSubmissionResponse(examSubmission);
    }

    @Transactional
    public CreateExamSubmissionResponse endExam(CreateExamSubmissionEndCommand createExamSubmissionEndCommand) {
        ExamSubmission examSubmission = examSubmissionCreateHelper.createEndExamSubmission(createExamSubmissionEndCommand);
        return examSubmissionDataMapper.mapToCreateExamSubmissionResponse(examSubmission);
    }

    @Transactional(readOnly = true)
    public QueryExamSubmissionResponse submitExamDetail(UUID submissionId) {
        return examSubmissionQueryHelper.submitExamDetail(submissionId);
    }

    @Transactional(readOnly = true)
    public List<QueryExamSubmissionOverviewResponse> findByExamIdAndUserId(UUID examId, UUID userId) {
        return examSubmissionQueryHelper.findByExamIdAndUserId(examId, userId);
    }

    public QueryExamSubmissionOverviewResponse findLatestOnGoingSubmission(UUID examId, UUID userId) {
        return examSubmissionQueryHelper.findLatestOnGoingSubmission(examId, userId);
    }
}
