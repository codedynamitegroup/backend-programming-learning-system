package com.backend.programming.learning.system.course.service.domain.implement.service.exam;

import com.backend.programming.learning.system.course.service.domain.dto.method.update.exam.UpdateExamCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.implement.exam
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 12:37 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamUpdateHelper {
    private final ExamRepository examRepository;
    private final CourseRepository courseRepository;

    public Exam updateExam(ExamId examId, UpdateExamCommand updateExamCommand) {
        Exam exam = examRepository.findBy(examId);
        Course course = courseRepository.findBy(updateExamCommand.courseId());
        exam.setCourse(course);
        exam.setName(updateExamCommand.name());
        exam.setIntro(updateExamCommand.intro());
        exam.setScore(updateExamCommand.score());
        exam.setMaxScore(updateExamCommand.maxScore());
        exam.setTimeOpen(updateExamCommand.timeOpen());
        exam.setTimeClose(updateExamCommand.timeClose());
        exam.setOverdueHanding(updateExamCommand.overdueHandling());
        return examRepository.save(exam);
    }

}
