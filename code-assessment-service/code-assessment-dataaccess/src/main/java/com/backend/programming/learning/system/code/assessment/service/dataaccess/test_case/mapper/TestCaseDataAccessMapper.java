package com.backend.programming.learning.system.code.assessment.service.dataaccess.test_case.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.test_case.entity.TestCaseEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.TestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TestCaseId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestCaseDataAccessMapper {
    public TestCase testCaseEntityToTestCase(TestCaseEntity entity){
        return TestCase.builder()
                .id(new TestCaseId(entity.getId()))
                .codeQuestionId(new CodeQuestionId(entity.getCodeQuestion().getId()))
                .inputData(entity.getInputData())
                .outputData(entity.getOutputData())
                .isSample(entity.getIsSample())
                .score(entity.getScore())
                .build();
    }
    public TestCaseEntity testCaseToTestCaseEntity(TestCase testCase){
        return TestCaseEntity.builder()
                .id(testCase.getId().getValue())
                .codeQuestion(CodeQuestionEntity.builder()
                        .id(testCase.getCodeQuestionId().getValue())
                        .build())
                .inputData(testCase.getInputData())
                .outputData(testCase.getOutputData())
                .isSample(testCase.getIsSample())
                .score(testCase.getScore())
                .build();
    }
    public List<TestCaseEntity> testCaseListToTestCaseEntityList(List<TestCase> testCases){
        return testCases.stream().map(this::testCaseToTestCaseEntity)
                .collect(Collectors.toList());
    }
    public List<TestCase> testCaseEntityListToTestCaseList(List<TestCaseEntity> entities){
        return entities.stream().map(this::testCaseEntityToTestCase)
                .collect(Collectors.toList());
    }
}
