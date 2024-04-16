package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Exam;

public interface ExamRepository {
    Exam saveExam(Exam exam);
}
