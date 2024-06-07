package com.backend.programming.learning.system.course.service.domain.implement.service.exam;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.mapper.exam.ExamDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

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
    private final ExamDataMapper examDataMapper;

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
        ExamSubmission examSubmission = examSubmissionRepository.findByExamId(examId);

        Integer numberOfStudent = examRepository.countStudent(examId);
        Integer numberOfSubmission = examSubmissionRepository.countSubmission(examId);
        Integer needGrading = 0;

        return QueryOverviewResponse.builder()
                .exam(examDataMapper.examToQueryExamResponse(exam))
                .numberOfStudents(numberOfStudent)
                .submitted(numberOfSubmission)
                .needGrading(numberOfStudent) // temp
                .build();
    }
}
