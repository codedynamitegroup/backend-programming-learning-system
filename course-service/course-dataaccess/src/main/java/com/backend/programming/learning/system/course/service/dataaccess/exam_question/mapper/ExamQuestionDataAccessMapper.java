package com.backend.programming.learning.system.course.service.dataaccess.exam_question.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.exam.mapper.ExamDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam_question.entity.ExamQuestionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.ExamQuestion;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamQuestionId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExamQuestionDataAccessMapper {
    private final ExamDataAccessMapper examDataAccessMapper;
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public ExamQuestionEntity examQuestionToExamQuestionEntity(ExamQuestion examQuestion) {
        return ExamQuestionEntity.builder()
                .id(examQuestion.getId().getValue())
                .build();
    }

    public ExamQuestion examQuestionEntityToExamQuestion(ExamQuestionEntity examQuestionEntity) {
        return ExamQuestion.builder()
                .id(new ExamQuestionId(examQuestionEntity.getId()))
                .exam(examDataAccessMapper.examEntityToExam(examQuestionEntity.getExam()))
                .question(questionDataAccessMapper.questionEntityToQuestion(examQuestionEntity.getQuestion()))
                .page(examQuestionEntity.getPage())
                .build();
    }

    public List<ExamQuestionEntity> examQuestionListToExamQuestionEntityList(List<ExamQuestion> examQuestions) {
        return examQuestions.stream()
                .map(this::ToExamQuestionEntity)
                .toList();
    }

    private ExamQuestionEntity ToExamQuestionEntity(ExamQuestion examQuestion) {
        return ExamQuestionEntity.builder()
                .id(examQuestion.getId().getValue())
                .exam(examDataAccessMapper.examToExamEntity(examQuestion.getExam()))
                .question(questionDataAccessMapper.questionToQuestionEntity(examQuestion.getQuestion()))
                .page(examQuestion.getPage())
                .build();
    }

    public List<ExamQuestion> examQuestionEntityListToExamQuestionList(List<ExamQuestionEntity> allByExamId) {
        return allByExamId.stream()
                .map(this::examQuestionEntityToExamQuestion)
                .toList();
    }
}
