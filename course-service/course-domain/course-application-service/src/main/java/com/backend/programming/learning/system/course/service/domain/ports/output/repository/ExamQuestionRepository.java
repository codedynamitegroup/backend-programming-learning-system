package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateQuestionExamCommand;
import com.backend.programming.learning.system.course.service.domain.entity.ExamQuestion;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;

import java.util.List;
import java.util.UUID;

public interface ExamQuestionRepository {
    ExamQuestion saveExamQuestion(ExamQuestion examQuestion);

    void assignExamToQuestions(List<ExamQuestion> examQuestions);

    void deleteByExamIdAndQuestionIdIn(UUID examId, List<CreateQuestionExamCommand> questionIds);

    void deleteByExamId(UUID value);

    List<ExamQuestion> findByExamId(ExamId examId);

    Float countByExamId(ExamId examId);
}
