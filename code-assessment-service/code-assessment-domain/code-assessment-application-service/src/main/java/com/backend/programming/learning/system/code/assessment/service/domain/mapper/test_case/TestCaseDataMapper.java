package com.backend.programming.learning.system.code.assessment.service.domain.mapper.test_case;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.TestCaseDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.testcase.GetTestCasesByQuestionIdResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.TestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TestCaseId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestCaseDataMapper {
    public List<TestCase> createTestCasesCommandToTestCaseList(CreateTestCasesCommand command){
        return command.getTestCases()
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
                .score(testCaseDto.getScore() != null? testCaseDto.getScore() : null)
                .isSample(testCaseDto.getIsSample())
                .inputData(testCaseDto.getInputData())
                .outputData(testCaseDto.getOutputData())
                .build();
    }
    public List<TestCase> updateTestCaseCommandToTestCases(List<TestCaseDto> testCases, CodeQuestion codeQuestion) {
        return testCases.stream().map(item->TestCase.builder()
                .id(item.getId() != null? new TestCaseId(item.getId()): null)
                .codeQuestionId(codeQuestion.getId())
                .score(item.getScore() != null? item.getScore(): 1)
                .isSample(item.getIsSample())
                .inputData(item.getInputData())
                .outputData(item.getOutputData())
                .build()).toList();


    }

    public GetTestCasesByQuestionIdResponse testCasesPageQueryToTestCasesReponse(Page<TestCase> testCases) {
        return GetTestCasesByQuestionIdResponse.builder()
                .currentPage(testCases.getNumber())
                .totalPages(testCases.getTotalPages())
                .totalItems(testCases.getTotalElements())
                .testCases(testCases.stream().map(this::testCaseToTestCaseDto).collect(Collectors.toList()))
                .build();
    }

    public TestCaseDto testCaseToTestCaseDto(TestCase testCase) {
        return TestCaseDto.builder()
                .id(testCase.getId().getValue())
                .inputData(testCase.getInputData())
                .outputData(testCase.getOutputData())
                .isSample(testCase.getIsSample())
                .score(testCase.getScore())
                .build();
    }
}
