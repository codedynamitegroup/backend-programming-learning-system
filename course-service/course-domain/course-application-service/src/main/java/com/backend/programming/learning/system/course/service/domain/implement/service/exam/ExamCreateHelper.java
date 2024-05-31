package com.backend.programming.learning.system.course.service.domain.implement.service.exam;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateQuestionExamCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.mapper.exam.ExamDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implemtent.exam
 * Create by Dang Ngoc Tien
 * Date 4/16/2024 - 9:00 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamCreateHelper {
    private final CourseDomainService courseDomainService;
    private final ExamDataMapper examDataMapper;
    private final ExamRepository examRepository;
    private final CourseRepository courseRepository;
    @Transactional
    public Exam persistExam(CreateExamCommand createExamCommand) {
        Course course = getCourse(createExamCommand.courseId());

        Integer maxPage = createExamCommand.questionIds().stream()
                .mapToInt(CreateQuestionExamCommand::page)
                .max()
                .orElse(0);

        Exam exam = examDataMapper.createExamCommandToExam(course, createExamCommand, maxPage);
        courseDomainService.createExam(exam);
        return saveExam(exam);
    }

    private Exam saveExam(Exam exam) {
        Exam saveExam = examRepository.save(exam);
        if (Objects.isNull(saveExam)) {
            log.error("Failed to save exam");
            throw new RuntimeException("Failed to save exam");
        }
        log.info("Exam saved successfully with id: {}", saveExam.getId());
        return saveExam;
    }
    private Course getCourse(UUID courseId) {
        Course course = courseRepository.findById(courseId);
        if (Objects.isNull(course)) {
            log.warn("Course with id: {} not found", courseId);
            throw new RuntimeException("Course not found");
        }
        return course;
    }
}
