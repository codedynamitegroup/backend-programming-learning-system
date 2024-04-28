package com.backend.programming.learning.system.code.assessment.service.domain.mapper.test_case;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.TestCaseDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.testcase.UpdateTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.TestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TestCaseId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestCaseDataMapper {
    public List<TestCase> createTestCasesCommandToTestCaseList(CreateTestCasesCommand command){
        return command.getTestCase()
                .stream()
                .map((TestCaseDto testCaseDto) ->
                        testCaseDtoToTestCase(testCaseDto,
                                new CodeQuestionId(command.getCodeQuestionId())))
                .collect(Collectors.toList());
    }

    public TestCase testCaseDtoToTestCase(TestCaseDto testCaseDto, CodeQuestionId codeQuestionId ) {
        return TestCase.builder()
                .codeQuestionId(codeQuestionId)
                .id(testCaseDto.getId()!=null?new TestCaseId(testCaseDto.getId()):null)
                .score(testCaseDto.getScore())
                .isSample(testCaseDto.isSample())
                .inputData(testCaseDto.getInputData())
                .outputData(testCaseDto.getOutputData())
                .build();
    }
    public TestCase updateTestCaseCommandToTestCase(UpdateTestCaseCommand command) {
        return TestCase.builder()
                .id(new TestCaseId(command.getId()))
                .score(command.getScore())
                .isSample(command.isSample())
                .inputData(command.getInputData())
                .outputData(command.getOutputData())
                .build();
    }

}
