package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.TestCaseEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.TestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TestCaseId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodeQuestionDataAccessMapper {
    public CodeQuestionEntity codeQuestionToCodeQuestionEntity(CodeQuestion codeQuestion){
        CodeQuestionEntity codeQuestionEntity = CodeQuestionEntity.builder()
                .id(codeQuestion.getId().getValue())
                .questionId(codeQuestion.getQuestionId().getValue())
                .dslTemplate(codeQuestion.getDslTemplate())
                .inputFormat(codeQuestion.getInputFormat())
                .outputFormat(codeQuestion.getOutputFormat())
                .isDeleted(codeQuestion.getIsDeleted())
                .constraints(codeQuestion.getConstraints())
                .testCases(testCasesToTestCaseEntities(codeQuestion.getTestCases()))
                .build();
        if(codeQuestionEntity.getTestCases() != null)
            codeQuestionEntity.getTestCases()
                    .forEach(testCaseEntity -> testCaseEntity.setCodeQuestion(codeQuestionEntity));
        return codeQuestionEntity;
    }
    public CodeQuestion codeQuestionEntityToCodeQuestion(CodeQuestionEntity codeQuestionEntity){
        CodeQuestion codeQuestion = CodeQuestion.builder()
                .questionId(new QuestionId(codeQuestionEntity.getQuestionId()))
                .codeQuestionId(new CodeQuestionId(codeQuestionEntity.getId()))
                .dslTemplate(codeQuestionEntity.getDslTemplate())
                .constraints(codeQuestionEntity.getConstraints())
                .inputFormat(codeQuestionEntity.getInputFormat())
                .outputFormat(codeQuestionEntity.getOutputFormat())
                .isDeleted(codeQuestionEntity.getIsDeleted())
                .testCases(testCaseEntitiesToTestCases(codeQuestionEntity.getTestCases()))
                .build();
        return codeQuestion;
    }

    private List<TestCase> testCaseEntitiesToTestCases(List<TestCaseEntity> testCaseEntities) {
        if(testCaseEntities == null) return null;
        return testCaseEntities.stream()
                .map(testCaseEntity -> TestCase.builder()
                        .id(new TestCaseId(testCaseEntity.getId()))
                        .inputData(testCaseEntity.getInputData())
                        .outputData(testCaseEntity.getOutputData())
                        .isSample(testCaseEntity.getIsSample())
                        .score(testCaseEntity.getScore())
                        .build())
                .collect(Collectors.toList());
    }

    private List<TestCaseEntity> testCasesToTestCaseEntities(List<TestCase> testCases) {
        if(testCases == null)
            return null;
        return testCases.stream()
                .map(testCase ->
                        TestCaseEntity.builder()
                                .id(testCase.getId().getValue())
                                .inputData(testCase.getInputData())
                                .outputData(testCase.getOutputData())
                                .isSample(testCase.getIsSample())
                                .score(testCase.getScore())
                                .build()
                ).collect(Collectors.toList());
    }
}
