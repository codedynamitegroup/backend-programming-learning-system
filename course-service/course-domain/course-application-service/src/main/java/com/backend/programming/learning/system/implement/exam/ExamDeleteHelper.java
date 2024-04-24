package com.backend.programming.learning.system.implement.exam;

import com.backend.programming.learning.system.dto.responseentity.exam.ExamResponseEntity;
import com.backend.programming.learning.system.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.valueobject.ExamId;
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
