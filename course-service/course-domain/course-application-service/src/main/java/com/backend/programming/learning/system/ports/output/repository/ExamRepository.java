package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.valueobject.ExamId;
import org.springframework.data.domain.Page;


public interface ExamRepository {
    Exam saveExam(Exam exam);

    Exam save(Exam exam);

    Exam findBy(ExamId examId);

    Page<Exam> findAll(String search, Integer pageNo, Integer pageSize);

    void deleteById(ExamId examId);
}
