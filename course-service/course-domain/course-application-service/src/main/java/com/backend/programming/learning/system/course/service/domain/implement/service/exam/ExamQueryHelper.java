package com.backend.programming.learning.system.course.service.domain.implement.service.exam;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryAllGradeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryGradeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryGradeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamQuestion;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.mapper.exam.ExamDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.exam_submission.ExamSubmissionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseUserRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamQuestionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implement.exam
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 9:22 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamQueryHelper {
    private final ExamRepository examRepository;
    private final ExamSubmissionRepository examSubmissionRepository;
    private final CourseUserRepository courseUserRepository;
    private final QuestionSubmissionRepository questionSubmissionRepository;
    private final ExamQuestionRepository examQuestionRepository;
    private final ExamDataMapper examDataMapper;
    private final ExamSubmissionDataMapper examSubmissionDataMapper;

    public Exam findBy(ExamId examId) {
        Exam exam = examRepository.findBy(examId);


        exam.setScore(examQuestionRepository.countByExamId(examId));
        log.info("Exam found successfully");
        return exam;
    }

    public Page<Exam> findAll(CourseId courseId, String search, Integer pageNo, Integer pageSize) {
        Page<Exam> exams = examRepository.findAll(courseId, search, pageNo, pageSize);
        log.info("Exams found successfully");
        return exams;
    }

    public QueryOverviewResponse overviewExam(ExamId examId) {
        Exam exam = examRepository.findBy(examId);
        List<ExamSubmission> examSubmission = examSubmissionRepository.findByExamId(examId);

        Integer numberOfStudent = examRepository.countStudent(examId);
        Integer numberOfSubmission = examSubmissionRepository.countSubmission(examId);
        Integer needGrading = 0;

        return QueryOverviewResponse.builder()
//                .exam(examDataMapper.examToQueryExamResponse(exam))
                .examSubmissionResponse(examSubmissionDataMapper.examSubmissionToQueryExamSubmission(examSubmission))
                .numberOfStudents(numberOfStudent)
                .submitted(numberOfSubmission)
                .needGrading(numberOfStudent) // temp
                .build();
    }

    public QueryAllGradeResponse gradeExam(ExamId examId, QueryGradeCommand queryGradeCommand) {
        Page<CourseUser> courseUsers = courseUserRepository.findByExamId(examId, queryGradeCommand);
        List<QueryGradeResponse> queryGradeResponses = new ArrayList<>();
        courseUsers.forEach(courseUser -> {
            Exam exam = examRepository.findBy(examId);
            Double totalGrade = Double.valueOf(exam.getMaxScore());
            Double grade = 0.0;
            List<ExamSubmission> examSubmissions = examSubmissionRepository
                    .findAllByExamIdAndUserId(examId.getValue(), courseUser.getUser().getId().getValue());
            if (exam.getGradeMethod().equals("QUIZ_GRADEHIGHEST")){
                grade = examSubmissions.stream()
                        .filter(examSubmission -> examSubmission.getScore() != null)
                        .mapToDouble(ExamSubmission::getScore)
                        .max()
                        .orElse(0.0);
            }
            if (exam.getGradeMethod().equals("QUIZ_GRADEAVERAGE")){
                grade = examSubmissions.stream()
                        .filter(examSubmission -> examSubmission.getScore() != null)
                        .mapToDouble(ExamSubmission::getScore)
                        .average()
                        .orElse(0.0);
            }
            if (exam.getGradeMethod().equals("QUIZ_ATTEMPTFIRST")){
                grade = examSubmissions.stream()
                        .filter(examSubmission -> examSubmission.getScore() != null)
                        .mapToDouble(ExamSubmission::getScore)
                        .findFirst()
                        .orElse(0.0);
            }
            if (exam.getGradeMethod().equals("QUIZ_ATTEMPTLAST")){
                grade = examSubmissions.stream()
                        .filter(examSubmission -> examSubmission.getScore() != null)
                        .mapToDouble(ExamSubmission::getScore)
                        .reduce((first, second) -> second)
                        .orElse(0.0);
            }

            ZonedDateTime lastSubmitAt = examSubmissions.stream()
                    .filter(examSubmission -> Objects.nonNull(examSubmission.getSubmitTime()))
                    .map(ExamSubmission::getSubmitTime)
                    .reduce((first, second) -> second)
                    .orElse(null);

            QueryGradeResponse queryGradeResponse = QueryGradeResponse.builder()
                    .userId(courseUser.getUser().getId().getValue())
                    .submissionId(examSubmissions.isEmpty() ? null : examSubmissions.get(0).getId().getValue())
                    .firstName(courseUser.getUser().getFirstName())
                    .lastName(courseUser.getUser().getLastName())
                    .email(courseUser.getUser().getEmail())
                    .lastSubmitAt(lastSubmitAt)
                    .lastMarkAt(null)
                    .status(examSubmissions.isEmpty() ? "NOT_SUBMITTED" : "SUBMITTED")
                    .score(Math.round(grade * 100.0) / 100.0)
                    .maxScore(totalGrade)
                    .build();
            queryGradeResponses.add(queryGradeResponse);
        });

        return QueryAllGradeResponse.builder()
                .grades(queryGradeResponses)
                .currentPage(courseUsers.getNumber())
                .totalItems(courseUsers.getTotalElements())
                .totalPages(courseUsers.getTotalPages())
                .build();
    }
}
