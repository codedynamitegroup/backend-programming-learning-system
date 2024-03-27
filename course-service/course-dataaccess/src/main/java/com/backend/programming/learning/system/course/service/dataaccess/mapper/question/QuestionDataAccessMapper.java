package com.backend.programming.learning.system.course.service.dataaccess.mapper.question;

import com.backend.programming.learning.system.course.service.dataaccess.entity.question.QuestionEntity;
import com.backend.programming.learning.system.course.service.domain.entity.question.Question;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.mapper.question
 * Create by Dang Ngoc Tien
 * Date 3/26/2024 - 11:40 PM
 * Description: ...
 */
@Component
public class QuestionDataAccessMapper {
    public QuestionEntity questionToQuestionEntity(Question question) {
        return QuestionEntity.builder()
                .orgId(question.getOrgId())
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(question.getDefaultMark())
                .createdBy(question.getCreatedBy())
                .updatedBy(question.getUpdatedBy())
                .qtype(question.getQtype())
                .difficulty(question.getDifficulty())
                .build();
    }

    public Question questionEntityToQuestion(QuestionEntity questionEntity) {
        return Question.builder()
                .id(questionEntity.getId())
                .orgId(questionEntity.getOrgId())
                .name(questionEntity.getName())
                .questionText(questionEntity.getQuestionText())
                .generalFeedback(questionEntity.getGeneralFeedback())
                .defaultMark(questionEntity.getDefaultMark())
                .createdBy(questionEntity.getCreatedBy())
                .updatedBy(questionEntity.getUpdatedBy())
                .qtype(questionEntity.getQtype())
                .difficulty(questionEntity.getDifficulty())
                .build();
    }

    public QuestionEntity updateQuestionEntity(QuestionEntity questionEntity, Question question) {
        questionEntity.setOrgId(question.getOrgId());
        questionEntity.setName(question.getName());
        questionEntity.setQuestionText(question.getQuestionText());
        questionEntity.setGeneralFeedback(question.getGeneralFeedback());
        questionEntity.setDefaultMark(question.getDefaultMark());
        questionEntity.setCreatedBy(question.getCreatedBy());
        questionEntity.setUpdatedBy(question.getUpdatedBy());
        questionEntity.setQtype(question.getQtype());
        questionEntity.setDifficulty(question.getDifficulty());
        return questionEntity;
    }
}
