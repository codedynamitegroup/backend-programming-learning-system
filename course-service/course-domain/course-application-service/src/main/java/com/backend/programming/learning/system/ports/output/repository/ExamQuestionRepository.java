package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.ExamQuestion;

import java.util.List;
import java.util.UUID;

public interface ExamQuestionRepository {
    ExamQuestion saveExamQuestion(ExamQuestion examQuestion);

    void assignExamToQuestions(List<ExamQuestion> examQuestions);

    void deleteByExamIdAndQuestionIdIn(UUID examId, List<UUID> questionIds);
}
