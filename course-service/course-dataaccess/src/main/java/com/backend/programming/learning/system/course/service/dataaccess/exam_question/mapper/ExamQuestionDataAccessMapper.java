package com.backend.programming.learning.system.course.service.dataaccess.exam_question.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.exam_question.entity.ExamQuestionEntity;
import com.backend.programming.learning.system.entity.ExamQuestion;
import com.backend.programming.learning.system.valueobject.ExamQuestionId;
import org.springframework.stereotype.Component;

@Component
public class ExamQuestionDataAccessMapper {

    public ExamQuestionEntity examQuestionToExamQuestionEntity(ExamQuestion examQuestion) {
        return ExamQuestionEntity.builder()
                .id(examQuestion.getId().getValue())
                .build();
    }

    public ExamQuestion examQuestionEntityToExamQuestion(ExamQuestionEntity examQuestionEntity) {
        return ExamQuestion.builder()
                .id(new ExamQuestionId(examQuestionEntity.getId()))
                .build();
    }
}
