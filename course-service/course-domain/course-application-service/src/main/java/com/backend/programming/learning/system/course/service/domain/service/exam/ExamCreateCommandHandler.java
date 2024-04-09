package com.backend.programming.learning.system.course.service.domain.service.exam;

import com.backend.programming.learning.system.course.service.domain.dto.exam.create.CreateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.exam.get.ExamsResponse;
import com.backend.programming.learning.system.course.service.domain.entity.exam.Exam;
import com.backend.programming.learning.system.course.service.domain.event.exam.ExamCreateEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.ExamDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.exam.ExamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain
 * Create by Dang Ngoc Tien
 * Date 3/21/2024 - 11:48 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamCreateCommandHandler {
    private final ExamDomainService examDomainService;
    private final ExamRepository examRepository;
    private final ExamDataMapper examDataMapper;

    @Transactional
    public ExamCreateEvent createExam(CreateExamCommand createExamCommand) {
        Exam exam = examDataMapper.createExamCommandToExam(createExamCommand);
        ExamCreateEvent examCreateEvent = examDomainService.validateAndInitiateExam(exam);
        Exam saveExam = examRepository.createExam(exam);
        if (saveExam == null) {
            log.error("Failed to save exam");
            throw new RuntimeException("Failed to save exam");
        }
        log.info("Exam saved successfully");
        return examCreateEvent;
    }

    @Transactional(readOnly = true)
    public ExamsResponse findAll(String search) {
        List<Exam> exams = examRepository.findAll(search);
        return examDataMapper.examsToCreateExamResponses(exams, "Get list exam successfully");
    }

    @Transactional
    public void deleteExam(Long examId) {
        examRepository.deleteExam(examId);
    }

    @Transactional
    public ExamCreateEvent updateExam(Long examId, CreateExamCommand createExamCommand) {
        Exam exam = examDataMapper.createExamCommandToExam(createExamCommand);
        ExamCreateEvent examCreateEvent = examDomainService.validateAndUpdateExam(examId, exam);
        Exam updateExam = examRepository.updateExam(examId, exam);
        if (updateExam == null) {
            log.error("Failed to update exam");
            throw new RuntimeException("Failed to update exam");
        }
        log.info("Exam updated successfully");
        return examCreateEvent;
    }

    @Transactional(readOnly = true)
    public Exam getExam(Long examId) {
        return examRepository.getExam(examId);
    }
}
