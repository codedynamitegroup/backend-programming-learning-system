package com.backend.programming.learning.system.course.service.domain.implement.service.exam;

import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.implemtent.exam
 * Create by Dang Ngoc Tien
 * Date 4/16/2024 - 9:01 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamDeleteHelper {
    private final ExamRepository examRepository;
    public void deleteExam(ExamId examId) {
        log.info("Exam deleted with id: {}", examId);
        examRepository.deleteById(examId);
    }
}
