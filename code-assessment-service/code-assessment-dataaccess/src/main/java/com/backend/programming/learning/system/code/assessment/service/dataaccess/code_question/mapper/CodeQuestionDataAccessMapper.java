package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.question.mapper.QuestionDataAssessMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class CodeQuestionDataAccessMapper {

    private final QuestionDataAssessMapper questionDataAssessMapper;

    public CodeQuestionDataAccessMapper(QuestionDataAssessMapper questionDataAssessMapper) {
        this.questionDataAssessMapper = questionDataAssessMapper;
    }

    public CodeQuestionEntity codeQuestionToCodeQuestionEntity(CodeQuestion codeQuestion){
        CodeQuestionEntity codeQuestionEntity = CodeQuestionEntity.builder()
                .id(codeQuestion.getId().getValue())
                .questionId(codeQuestion.getQuestionId().getValue())
//                .question(questionDataAssessMapper.questionToQuestionEntity(new Question(codeQuestion.getQuestionId())))
                .name(codeQuestion.getName())
                .dslTemplate(codeQuestion.getDslTemplate())
                .problemStatement(codeQuestion.getProblemStatement())
                .inputFormat(codeQuestion.getInputFormat())
                .outputFormat(codeQuestion.getOutputFormat())
                .constraints(codeQuestion.getConstraints())
                .copyState(codeQuestion.getCopyState())
                .maxGrade(codeQuestion.getMaxGrade())
                .isPublic(codeQuestion.getIsPublic())
                .failureMessages(codeQuestion.getFailureMessages() != null ?
                        String.join(CodeQuestion.FAILURE_MESSAGE_DELIMITER, codeQuestion.getFailureMessages()) : "")
                .build();
        return codeQuestionEntity;
    }
    public CodeQuestion codeQuestionEntityToCodeQuestion(CodeQuestionEntity codeQuestionEntity){
        CodeQuestion codeQuestion = CodeQuestion.builder()
//                .questionId(new QuestionId(codeQuestionEntity.getQuestion().getId()))
                .questionId(new QuestionId(codeQuestionEntity.getQuestionId()))
                .codeQuestionId(new CodeQuestionId(codeQuestionEntity.getId()))
                .name(codeQuestionEntity.getName())
                .dslTemplate(codeQuestionEntity.getDslTemplate())
                .constraints(codeQuestionEntity.getConstraints())
                .inputFormat(codeQuestionEntity.getInputFormat())
                .outputFormat(codeQuestionEntity.getOutputFormat())
                .copyState(codeQuestionEntity.getCopyState())
                .maxGrade(codeQuestionEntity.getMaxGrade())
                .isPublic(codeQuestionEntity.getIsPublic())
                .failureMessages(codeQuestionEntity.getFailureMessages()==null || codeQuestionEntity.getFailureMessages().isEmpty() ? new ArrayList<>() :
                        new ArrayList<>(Arrays.asList(codeQuestionEntity.getFailureMessages()
                                .split(CodeQuestion.FAILURE_MESSAGE_DELIMITER))))
                .build();
        return codeQuestion;
    }
}
