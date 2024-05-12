package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
class CodeQuestionApplicationServiceImpl implements CodeQuestionApplicationService {
    private final CodeQuestionCreateCommandHandler codeQuestionCreateCommandHandler;

    public CodeQuestionApplicationServiceImpl(CodeQuestionCreateCommandHandler codeQuestionCreateCommandHandler) {
        this.codeQuestionCreateCommandHandler = codeQuestionCreateCommandHandler;
    }

    @Override
    public CreateCodeQuestionResponse createCodeQuestion(CreateCodeQuestionCommand command) {
        return codeQuestionCreateCommandHandler.createCodeQuestion(command);
    }

    @Override
    public GetCodeQuestionsResponse getCodeQuestions(GetCodeQuestionsCommand command) {
        return codeQuestionCreateCommandHandler.getCodeQuestions(command);
    }
}
