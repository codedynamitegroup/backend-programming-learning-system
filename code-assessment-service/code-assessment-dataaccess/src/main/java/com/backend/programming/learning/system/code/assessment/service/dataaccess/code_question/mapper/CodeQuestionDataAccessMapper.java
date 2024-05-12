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
    private final CodeQuestionFieldToCodeQuestionEntityField codeQuestionFieldToCodeQuestionEntityField;

    public CodeQuestionDataAccessMapper(QuestionDataAssessMapper questionDataAssessMapper, CodeQuestionFieldToCodeQuestionEntityField codeQuestionFieldToCodeQuestionEntityField) {
        this.questionDataAssessMapper = questionDataAssessMapper;
        this.codeQuestionFieldToCodeQuestionEntityField = codeQuestionFieldToCodeQuestionEntityField;
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
                .difficulty(codeQuestion.getDifficulty())
                .createdAt(codeQuestion.getCreatedAt())
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
                .problemStatement(codeQuestionEntity.getProblemStatement())
                .dslTemplate(codeQuestionEntity.getDslTemplate())
                .constraints(codeQuestionEntity.getConstraints())
                .inputFormat(codeQuestionEntity.getInputFormat())
                .outputFormat(codeQuestionEntity.getOutputFormat())
                .copyState(codeQuestionEntity.getCopyState())
                .maxGrade(codeQuestionEntity.getMaxGrade())
                .isPublic(codeQuestionEntity.getIsPublic())
                .difficulty(codeQuestionEntity.getDifficulty())
                .createdAt(codeQuestionEntity.getCreatedAt())
                .failureMessages(codeQuestionEntity.getFailureMessages()==null || codeQuestionEntity.getFailureMessages().isEmpty() ? new ArrayList<>() :
                        new ArrayList<>(Arrays.asList(codeQuestionEntity.getFailureMessages()
                                .split(CodeQuestion.FAILURE_MESSAGE_DELIMITER))))
                .build();
        return codeQuestion;
    }
    public CodeQuestion codeQuestionEntityToCodeQuestion(CodeQuestionEntity codeQuestionEntity, Boolean done){
        CodeQuestion codeQuestion = CodeQuestion.builder()
//                .questionId(new QuestionId(codeQuestionEntity.getQuestion().getId()))
                .questionId(new QuestionId(codeQuestionEntity.getQuestionId()))
                .codeQuestionId(new CodeQuestionId(codeQuestionEntity.getId()))
                .name(codeQuestionEntity.getName())
                .problemStatement(codeQuestionEntity.getProblemStatement())
                .dslTemplate(codeQuestionEntity.getDslTemplate())
                .constraints(codeQuestionEntity.getConstraints())
                .inputFormat(codeQuestionEntity.getInputFormat())
                .outputFormat(codeQuestionEntity.getOutputFormat())
                .copyState(codeQuestionEntity.getCopyState())
                .maxGrade(codeQuestionEntity.getMaxGrade())
                .isPublic(codeQuestionEntity.getIsPublic())
                .difficulty(codeQuestionEntity.getDifficulty())
                .createdAt(codeQuestionEntity.getCreatedAt())
                .solved(done)
                .failureMessages(codeQuestionEntity.getFailureMessages()==null || codeQuestionEntity.getFailureMessages().isEmpty() ? new ArrayList<>() :
                        new ArrayList<>(Arrays.asList(codeQuestionEntity.getFailureMessages()
                                .split(CodeQuestion.FAILURE_MESSAGE_DELIMITER))))
                .build();
        return codeQuestion;
    }

    public String codeQuestionFieldToCodeQuestionEntityField(String name) {
        return codeQuestionFieldToCodeQuestionEntityField.fieldMapper.get(name);
    }
}
