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
            List<QuestionSubmission> questionSubmissions = questionSubmissionRepository
                    .findByExamIdAndUserId(examId, courseUser.getUser().getId());
            List<ExamQuestion> examQuestions = examQuestionRepository
                    .findByExamId(examId);
            Exam exam = examRepository.findBy(examId);
            ExamSubmission examSubmission = examSubmissionRepository.findByExamAndUser(exam, courseUser.getUser());

            Double totalGrade = Double.valueOf(exam.getMaxScore());
            Double mark = questionSubmissions.stream()
                    .filter(questionSubmission -> Objects.nonNull(questionSubmission.getGrade()))
                    .mapToDouble(QuestionSubmission::getGrade)
                    .sum();
            Double totalMark = examQuestions.stream()
                    .filter(examQuestion -> examQuestion.getQuestion() != null)
                    .mapToDouble(examQuestion -> examQuestion.getQuestion().getDefaultMark())
                    .sum();

            Double grade = Math.round((mark / totalMark) * totalGrade * 100.0) / 100.0;

            QueryGradeResponse queryGradeResponse = QueryGradeResponse.builder()
                    .userId(courseUser.getUser().getId().getValue())
                    .submissionId(Objects.isNull(examSubmission.getId()) ? null : examSubmission.getId().getValue())
                    .firstName(courseUser.getUser().getFirstName())
                    .lastName(courseUser.getUser().getLastName())
                    .email(courseUser.getUser().getEmail())
                    .lastSubmitAt(examSubmission.getSubmitTime())
                    .lastMarkAt(examSubmission.getSubmitTime())
                    .status(Objects.isNull(examSubmission.status()) ? "NOT_SUBMITTED" : "SUBMITTED")
                    .score(grade)
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
