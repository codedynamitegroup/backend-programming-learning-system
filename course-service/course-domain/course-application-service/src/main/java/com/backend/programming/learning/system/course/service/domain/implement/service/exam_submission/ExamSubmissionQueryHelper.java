package com.backend.programming.learning.system.course.service.domain.implement.service.exam_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.mapper.exam_submission.ExamSubmissionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
public class ExamSubmissionQueryHelper {
    private final ExamSubmissionRepository examSubmissionRepository;
    private final QuestionSubmissionRepository questionSubmissionRepository;
    private final ExamSubmissionDataMapper examSubmissionDataMapper;

    public QueryExamSubmissionResponse submitExamDetail(UUID submissionId) {
        ExamSubmission examSubmission = examSubmissionRepository.findBy(submissionId);
        List<QuestionSubmission> questionSubmissions = questionSubmissionRepository.findAllByExamSubmissionId(submissionId);
        return examSubmissionDataMapper.mapToQueryExamSubmissionResponse(examSubmission, questionSubmissions);
    }

    public List<QueryExamSubmissionOverviewResponse> findByExamIdAndUserId(UUID examId, UUID userId) {
        List<QueryExamSubmissionOverviewResponse> examSubmissionResponses = new ArrayList<>();
        List<ExamSubmission> examSubmissions = examSubmissionRepository.findAllByExamIdAndUserId(examId, userId);

        examSubmissions.forEach(examSubmission -> {
            List<QuestionSubmission> questionSubmissions = questionSubmissionRepository
                    .findAllByExamSubmissionId(examSubmission.getId().getValue());
//            examSubmissionResponses.add(examSubmissionDataMapper.mapToQueryExamSubmissionResponse(examSubmission, questionSubmissions));

            Double markTotal = questionSubmissions.stream()
                    .filter(questionSubmission -> questionSubmission.getGrade() != null)
                    .mapToDouble(QuestionSubmission::getGrade)
                    .sum();
            examSubmissionResponses.add(examSubmissionDataMapper.mapToQueryExamSubmissionResponseWithTotal(examSubmission, markTotal));
        });

        return examSubmissionResponses;
    }
}
