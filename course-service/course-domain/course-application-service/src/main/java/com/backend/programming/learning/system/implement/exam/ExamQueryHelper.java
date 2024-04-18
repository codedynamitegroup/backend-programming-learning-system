package com.backend.programming.learning.system.implement.exam;

import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.valueobject.ExamId;
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
    public Exam findBy(ExamId examId) {
        Exam exam = examRepository.findBy(examId);
        log.info("Exam found successfully");
        return exam;
    }

    public Page<Exam> findAll(String search, Integer pageNo, Integer pageSize) {
        Page<Exam> exams = examRepository.findAll(search, pageNo, pageSize);
        log.info("Exams found successfully");
        return exams;
    }
}
