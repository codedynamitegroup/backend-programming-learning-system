package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.ExamQuestion;

public interface ExamQuestionRepository {
    ExamQuestion saveExamQuestion(ExamQuestion examQuestion);
}
