package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import org.springframework.data.domain.Page;


public interface ExamRepository {
    Exam save(Exam exam);

    Exam findBy(ExamId examId);

    Page<Exam> findAll(String search, Integer pageNo, Integer pageSize);

    void deleteById(ExamId examId);
}
