package com.backend.programming.learning.system.implemtent.exam;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.create.CreateExamCommand;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.mapper.ExamDataMapper;
import com.backend.programming.learning.system.ports.output.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

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
    @Transactional
    public Exam persistExam(CreateExamCommand createExamCommand) {
        Exam exam = examDataMapper.createExamCommandToExam(createExamCommand);
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
}
