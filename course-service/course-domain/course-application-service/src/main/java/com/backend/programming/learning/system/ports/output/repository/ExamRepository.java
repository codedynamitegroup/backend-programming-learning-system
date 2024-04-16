package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.valueobject.ExamId;

import java.util.List;

public interface ExamRepository {
    Exam saveExam(Exam exam);

    Exam save(Exam exam);

    Exam findBy(ExamId examId);

    List<Exam> findAll(String search);
}
