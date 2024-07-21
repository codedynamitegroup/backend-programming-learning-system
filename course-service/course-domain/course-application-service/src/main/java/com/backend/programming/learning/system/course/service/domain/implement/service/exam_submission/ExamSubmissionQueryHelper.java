package com.backend.programming.learning.system.course.service.domain.implement.service.exam_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryGradeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryAllStudentExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryAllStudentExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryStudentExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.exception.ExamSubmissionNotFoundException;
import com.backend.programming.learning.system.course.service.domain.mapper.exam_submission.ExamSubmissionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseUserRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamSubmissionId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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
    private final ExamRepository examRepository;
    private final QuestionSubmissionRepository questionSubmissionRepository;
    private final CourseUserRepository courseUserRepository;
    private final ExamSubmissionDataMapper examSubmissionDataMapper;

    public QueryExamSubmissionResponse submitExamDetail(UUID submissionId) {
        ExamSubmission examSubmission = examSubmissionRepository.findBy(submissionId);
        List<QuestionSubmission> questionSubmissions = questionSubmissionRepository.findAllByExamSubmissionId(submissionId);
        return examSubmissionDataMapper.mapToQueryExamSubmissionResponse(examSubmission, questionSubmissions);
    }

    public List<QueryExamSubmissionOverviewResponse> findByExamIdAndUserId(UUID examId, UUID userId) {
        List<QueryExamSubmissionOverviewResponse> examSubmissionResponses = new ArrayList<>();
        List<ExamSubmission> examSubmissions = examSubmissionRepository.findAllByExamIdAndUserId(examId, userId);
        Exam exam = examRepository.findBy(new ExamId(examId));
        Double maxGrade = Double.valueOf(exam.getMaxScore());

        examSubmissions.forEach(examSubmission -> {
            List<QuestionSubmission> questionSubmissions = questionSubmissionRepository
                    .findAllByExamSubmissionId(examSubmission.getId().getValue());
//            examSubmissionResponses.add(examSubmissionDataMapper.mapToQueryExamSubmissionResponse(examSubmissionResponse, questionSubmissions));

            Double mark = questionSubmissions.stream()
                    .filter(questionSubmission -> questionSubmission.getGrade() != null)
                    .mapToDouble(QuestionSubmission::getGrade)
                    .sum();

            Double markTotal = questionSubmissions.stream()
                    .filter(questionSubmission -> questionSubmission.getQuestion() != null)
                    .mapToDouble(value -> value.getQuestion().getDefaultMark())
                    .sum();

            Double grade = Math.round((mark / markTotal) * maxGrade * 100.0) / 100.0;

            examSubmissionResponses.add(examSubmissionDataMapper
                    .mapToQueryExamSubmissionResponse(examSubmission, mark, markTotal, grade, maxGrade));
        });

        return examSubmissionResponses;
    }

    public QueryExamSubmissionOverviewResponse findLatestOnGoingSubmission(UUID examId, UUID userId) {
        ExamSubmission examSubmission = examSubmissionRepository.findLatestExamSubmissionByExamIdAndUserId(examId, userId).orElseThrow(() -> {
            log.error("Exam submission not found");
            return new ExamSubmissionNotFoundException("Exam submission not found");
        });

        if (!Objects.isNull(examSubmission.getSubmitTime())) {
            log.warn("There is no on going exam submission");
            throw new ExamSubmissionNotFoundException("There is no on going exam submission");
        }

        return examSubmissionDataMapper.mapToQueryExamSubmissionResponseWithTotal(examSubmission, 0.0);
    }

    public QueryAllStudentExamSubmissionResponse findByExamId(ExamId examId, QueryAllStudentExamSubmissionCommand queryAllStudentExamSubmissionCommand) {
        QueryGradeCommand queryGradeCommand = QueryGradeCommand.builder()
                .pageNo(queryAllStudentExamSubmissionCommand.pageNo())
                .pageSize(queryAllStudentExamSubmissionCommand.pageSize())
                .search(queryAllStudentExamSubmissionCommand.search())
                .build();
        Page<CourseUser> courseUsers = courseUserRepository.findByExamId(examId, queryGradeCommand);
        Exam exam = examRepository.findBy(examId);
        Double maxGrade = Double.valueOf(exam.getMaxScore());
        List<QueryStudentExamSubmissionResponse> queryStudentExamSubmissionResponses = new ArrayList<>();

        courseUsers.forEach(courseUser -> {
            ExamSubmission examSubmission = examSubmissionRepository
                    .findLatestExamSubmissionByExamIdAndUserId(examId.getValue(), courseUser.getUser().getId().getValue()).orElse(null);
            if (Objects.isNull(examSubmission)) {
                queryStudentExamSubmissionResponses.add(QueryStudentExamSubmissionResponse.builder()
                        .examId(examId.getValue())
                        .userId(courseUser.getUser().getId().getValue())
                        .firstName(courseUser.getUser().getFirstName())
                        .lastName(courseUser.getUser().getLastName())
                        .email(courseUser.getUser().getEmail())
                        .status("NOT_SUBMITTED")
                        .statusGrade("NOT_GRADED")
                        .mark(0.0)
                        .totalMark(0.0)
                        .grade(0.0)
                        .totalGrade(maxGrade)
                        .build());
            } else {
                List<QuestionSubmission> questionSubmissions = questionSubmissionRepository
                        .findAllByExamSubmissionId(examSubmission.getId().getValue());
                Double mark = questionSubmissions.stream()
                        .filter(questionSubmission -> questionSubmission.getGrade() != null)
                        .mapToDouble(QuestionSubmission::getGrade)
                        .sum();
                Double totalMark = questionSubmissions.stream()
                        .filter(questionSubmission -> questionSubmission.getQuestion() != null)
                        .mapToDouble(value -> value.getQuestion().getDefaultMark())
                        .sum();

                Double grade = Math.round((mark / totalMark) * maxGrade * 100.0) / 100.0;

                queryStudentExamSubmissionResponses.add(QueryStudentExamSubmissionResponse.builder()
                        .examSubmissionId(examSubmission.getId().getValue())
                        .examId(examSubmission.getExam().getId().getValue())
                        .userId(examSubmission.getUser().getId().getValue())
                        .firstName(examSubmission.getUser().getFirstName())
                        .lastName(examSubmission.getUser().getLastName())
                        .email(examSubmission.getUser().getEmail())
                        .status("SUBMITTED")
                        .statusGrade("GRADED")
                        .mark(mark)
                        .totalMark(totalMark)
                        .grade(grade)
                        .totalGrade(maxGrade)
                        .build());
            }
        });


        return QueryAllStudentExamSubmissionResponse.builder()
                .studentExamSubmissionResponses(queryStudentExamSubmissionResponses)
                .currentPage(courseUsers.getNumber())
                .totalPages(courseUsers.getTotalPages())
                .totalItems(courseUsers.getTotalElements())
                .build();
    }

    public QueryStudentExamSubmissionResponse findByExamIdAndSubmissionId(ExamId examId, ExamSubmissionId examSubmissionId) {
        Exam exam = examRepository.findBy(examId);
        Double maxGrade = Double.valueOf(exam.getMaxScore());

        ExamSubmission examSubmission = examSubmissionRepository.findBy(examSubmissionId.getValue());
        List<QuestionSubmission> questionSubmissions = questionSubmissionRepository.findAllByExamSubmissionId(examSubmissionId.getValue());
        Double mark = questionSubmissions.stream()
                .filter(questionSubmission -> questionSubmission.getGrade() != null)
                .mapToDouble(QuestionSubmission::getGrade)
                .sum();
        Double totalMark = questionSubmissions.stream()
                .filter(questionSubmission -> questionSubmission.getQuestion() != null)
                .mapToDouble(value -> value.getQuestion().getDefaultMark())
                .sum();
        Double grade = Math.round((mark / totalMark) * maxGrade * 100.0) / 100.0;

        QueryStudentExamSubmissionResponse queryStudentExamSubmissionResponse = QueryStudentExamSubmissionResponse.builder()
                .examSubmissionId(examSubmissionId.getValue())
                .examId(examId.getValue())
                .userId(examSubmission.getUser().getId().getValue())
                .firstName(examSubmission.getUser().getFirstName())
                .lastName(examSubmission.getUser().getLastName())
                .email(examSubmission.getUser().getEmail())
                .status("SUBMITTED")
                .statusGrade("GRADED")
                .mark(mark)
                .totalMark(totalMark)
                .grade(grade)
                .totalGrade(maxGrade)
                .build();

        return queryStudentExamSubmissionResponse;
    }
}
