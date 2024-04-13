package com.backend.programming.learning.system.code.assessment.service.domain.mapper;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.TestCase;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodeQuestionDataMaper {
    public CodeQuestion createCodeQuestionCommandToCodeQuestion(CreateCodeQuestionCommand command){
        return CodeQuestion.Builder.builder()
                .questionId(new QuestionId(command.getQuestionId()))
                .testCases(testCaseToTestCaseEntities(command.getTestCases()))
                .dslTemplate(command.getDslTemplate())
                .problemStatement(command.getProblemStatement())
                .inputFormat(command.getInputFormat())
                .outputFormat(command.getOutputFormat())
                .isDeleted(command.getIsDeleted())
                .build();
    }
    public CreateCodeQuestionResponse codeQuestionToCreateCodeQuestionReponse(CodeQuestion codeQuestion){
        return CreateCodeQuestionResponse.builder()
                .codeQuestionId(codeQuestion.getId())
                .message("create code question success fully")
                .build();
    }

    private List<TestCase> testCaseToTestCaseEntities(
            List<com.backend.programming.learning.system.code.assessment.service.domain.dto.create.TestCase> testCases) {
        if(testCases == null) return null;
        return testCases.stream().map(testCase->
                                        TestCase.Builder.builder()
                                            .inputData(testCase.getInputData())
                                            .outputData(testCase.getOutputData())
                                            .isSample(testCase.isSample())
                                            .build()).collect(Collectors.toList());
    }


}
