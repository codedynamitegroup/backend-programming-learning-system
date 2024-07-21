package com.backend.programming.learning.system.course.service.domain.implement.service.exam;

import com.backend.programming.learning.system.course.service.domain.dto.method.update.exam.UpdateExamCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ModuleRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SectionRepository;
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
    private final ModuleRepository moduleRepository;
    private final SectionRepository sectionRepository;

    public Exam updateExam(ExamId examId, UpdateExamCommand updateExamCommand) {
        Module module = moduleRepository.findByExamId(examId)
                .orElseThrow(() -> new RuntimeException("Module not found"));
        Section section = sectionRepository.findById(updateExamCommand.sectionId())
                .orElseThrow(() -> new RuntimeException("Section not found"));
        module.setSection(section);

        Exam exam = examRepository.findBy(examId);
        Course course = courseRepository.findBy(updateExamCommand.courseId());
        exam.setCourse(course);
        exam.setName(updateExamCommand.name());
        exam.setIntro(updateExamCommand.intro());
        exam.setScore(updateExamCommand.score());
        exam.setMaxScore(updateExamCommand.maxScore());
        exam.setTimeOpen(updateExamCommand.timeOpen());
        exam.setTimeClose(updateExamCommand.timeClose());
        exam.setTimeLimit(updateExamCommand.timeLimit());
        exam.setTimeLimitUnit(updateExamCommand.timeLimitUnit());
        exam.setUnit(updateExamCommand.unit());
        exam.setOverdueHanding(updateExamCommand.overdueHandling());

        moduleRepository.save(module);
        return examRepository.save(exam);
    }

}
