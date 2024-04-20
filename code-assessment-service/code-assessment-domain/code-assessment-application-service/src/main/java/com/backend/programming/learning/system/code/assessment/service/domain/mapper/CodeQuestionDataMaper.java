package com.backend.programming.learning.system.code.assessment.service.domain.mapper;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.codequestion.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.codequestion.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.TestCase;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodeQuestionDataMaper {
    public CodeQuestion createCodeQuestionCommandToCodeQuestion(CreateCodeQuestionCommand command){
        return CodeQuestion.builder()
                .questionId(new QuestionId(command.getQuestionId()))
                .dslTemplate(command.getDslTemplate())
                .problemStatement(command.getProblemStatement())
                .inputFormat(command.getInputFormat())
                .outputFormat(command.getOutputFormat())
                .constraints(command.getConstraints())
                .build();
    }
    public CreateCodeQuestionResponse codeQuestionToCreateCodeQuestionReponse(CodeQuestion codeQuestion, String message){
        return CreateCodeQuestionResponse.builder()
                .codeQuestionId(codeQuestion.getId())
                .state(codeQuestion.getCopyState())
                .message(message)
                .build();
    }


}
