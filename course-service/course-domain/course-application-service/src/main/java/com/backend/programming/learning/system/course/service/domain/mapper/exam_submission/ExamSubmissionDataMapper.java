package com.backend.programming.learning.system.course.service.domain.mapper.exam_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.ExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.Status;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.backend.programming.learning.system.mapper.exam_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:23 AM
 * Description: ...
 */
@Component
public class ExamSubmissionDataMapper {
    public ExamSubmission createExamSubmissionCommandToExamSubmission(
            Exam exam, User user,
            Integer submissionCount,
            CreateExamSubmissionCommand createExamSubmissionCommand) {
        return ExamSubmission.builder()
                .exam(exam)
                .user(user)
                .submissionCount(submissionCount)
                .startTime(createExamSubmissionCommand.startTime())
                .submitTime(createExamSubmissionCommand.submitTime())
                .build();
    }

    public CreateExamSubmissionResponse mapToCreateExamSubmissionResponse(ExamSubmission examSubmission) {
        return new CreateExamSubmissionResponse(
                examSubmission.getId().getValue(),
                examSubmission.getExam().getId().getValue(),
                examSubmission.getUser().getId().getValue(),
                examSubmission.getStartTime(),
                examSubmission.getSubmitTime(),
                examSubmission.status()
        );
    }

    public ExamSubmission createStartExamSubmissionCommandToExamSubmission(
            Exam exam,
            User user,
            Integer submissionCount,
            CreateExamSubmissionStartCommand createExamSubmissionStartCommand) {
        return ExamSubmission.builder()
                .exam(exam)
                .user(user)
                .submissionCount(submissionCount)
                .status(Status.NOT_SUBMITTED)
                .build();
    }

    public QueryExamSubmissionResponse mapToQueryExamSubmissionResponse(
            ExamSubmission examSubmission, List<QuestionSubmission> questionSubmissions) {

        return QueryExamSubmissionResponse.builder()
                .examSubmissionId(examSubmission.getId().getValue())
                .examId(examSubmission.getExam().getId().getValue())
                .userId(examSubmission.getUser().getId().getValue())
                .startTime(examSubmission.getStartTime())
                .submitTime(examSubmission.getSubmitTime())
                .status(examSubmission.status())
                .questionSubmissionResponses(mapToQuestionSubmissions(questionSubmissions))
                .build();
    }

    private List<QuestionSubmissionResponse> mapToQuestionSubmissions(List<QuestionSubmission> questionSubmissions) {
        return questionSubmissions.stream()
                .map(questionSubmission -> QuestionSubmissionResponse.builder()
                        .questionId(questionSubmission.getQuestion().getId().getValue())
                        .examSubmissionId(questionSubmission.getExamSubmission().getId().getValue())
                        .userId(questionSubmission.getUser().getId().getValue())
                        .passStatus(questionSubmission.getPassStatus())
                        .grade(questionSubmission.getGrade())
                        .content(questionSubmission.getContent())
                        .rightAnswer(questionSubmission.getRightAnswer())
                        .numFile(questionSubmission.getNumFile())
                        .build())
                .toList();
    }

    public QueryExamSubmissionOverviewResponse mapToQueryExamSubmissionResponseWithTotal(ExamSubmission examSubmission, Double markTotal) {
        return QueryExamSubmissionOverviewResponse.builder()
                .examSubmissionId(examSubmission.getId().getValue())
                .examId(examSubmission.getExam().getId().getValue())
                .userId(examSubmission.getUser().getId().getValue())
                .startTime(examSubmission.getStartTime())
                .submitTime(examSubmission.getSubmitTime())
                .status(examSubmission.status())
                .markTotal(markTotal)
                .build();
    }

    public List<ExamSubmissionResponse> examSubmissionToQueryExamSubmission(List<ExamSubmission> examSubmission) {
        return examSubmission.stream()
                .map(this::examSubmissionToQueryExamSubmissionResponse)
                .toList();
    }

    private ExamSubmissionResponse examSubmissionToQueryExamSubmissionResponse(ExamSubmission examSubmission) {
        return ExamSubmissionResponse.builder()
                .examSubmissionId(examSubmission.getId().getValue())
                .studentId(examSubmission.getUser().getId().getValue())
                .firstName(examSubmission.getUser().getFirstName())
                .lastName(examSubmission.getUser().getLastName())
                .startTime(examSubmission.getStartTime())
                .submitTime(examSubmission.getSubmitTime())
                .status(examSubmission.status())
                .build();
    }

}
