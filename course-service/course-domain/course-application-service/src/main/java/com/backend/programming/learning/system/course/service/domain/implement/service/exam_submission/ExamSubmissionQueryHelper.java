package com.backend.programming.learning.system.course.service.domain.implement.service.exam_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.exception.ExamSubmissionNotFoundException;
import com.backend.programming.learning.system.course.service.domain.mapper.exam_submission.ExamSubmissionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
//            examSubmissionResponses.add(examSubmissionDataMapper.mapToQueryExamSubmissionResponse(examSubmissionResponse, questionSubmissions));

            Double markTotal = questionSubmissions.stream()
                    .filter(questionSubmission -> questionSubmission.getGrade() != null)
                    .mapToDouble(QuestionSubmission::getGrade)
                    .sum();
            examSubmissionResponses.add(examSubmissionDataMapper.mapToQueryExamSubmissionResponseWithTotal(examSubmission, markTotal));
        });

        return examSubmissionResponses;
    }

    public QueryExamSubmissionOverviewResponse findLatestOnGoingSubmission(UUID examId, UUID userId) {
        ExamSubmission examSubmission = examSubmissionRepository.findLatestExamSubmissionByExamIdAndUserId(examId, userId).orElseThrow(() -> {
            log.error("Exam submission not found");
            return new ExamSubmissionNotFoundException("Exam submission not found");
        });

        if(!Objects.isNull(examSubmission.getSubmitTime())){
            log.warn("There is no on going exam submission");
            throw new ExamSubmissionNotFoundException("There is no on going exam submission");
        }

        return examSubmissionDataMapper.mapToQueryExamSubmissionResponseWithTotal(examSubmission, 0.0);
    }
}
