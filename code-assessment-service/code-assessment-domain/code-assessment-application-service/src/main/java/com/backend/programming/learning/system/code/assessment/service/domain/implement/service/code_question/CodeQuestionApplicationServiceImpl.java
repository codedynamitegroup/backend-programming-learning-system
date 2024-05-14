package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CodeQuestionDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.langauge.AddLanguageToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.langauge.DeleteLanguageToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetDetailCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_question.UpdateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
class CodeQuestionApplicationServiceImpl implements CodeQuestionApplicationService {
    private final CodeQuestionCommandHandler codeQuestionCommandHandler;

    public CodeQuestionApplicationServiceImpl(CodeQuestionCommandHandler codeQuestionCommandHandler) {
        this.codeQuestionCommandHandler = codeQuestionCommandHandler;
    }

    @Override
    public CreateCodeQuestionResponse createCodeQuestion(CreateCodeQuestionCommand command) {
        return codeQuestionCommandHandler.createCodeQuestion(command);
    }

    @Override
    public GetCodeQuestionsResponse getCodeQuestions(GetCodeQuestionsCommand command) {
        return codeQuestionCommandHandler.getCodeQuestions(command);
    }

    @Override
    public void updateCodeQuestion(UpdateCodeQuestionCommand command) {
        codeQuestionCommandHandler.updateCodeQuestion(command);
    }

    @Override
    public CodeQuestionDto getDetailCodeQuestion(GetDetailCodeQuestionCommand command) {
        return codeQuestionCommandHandler.getDetailCodeQuestion(command);
    }

    @Override
    public void addLanguageToCodeQuestion(AddLanguageToCodeQuestionCommand command) {
        codeQuestionCommandHandler.addLanguageToCodeQuestion(command);
    }

    @Override
    public void deleteProgrammingLanguageCodeQuestion(DeleteLanguageToCodeQuestionCommand command) {
        codeQuestionCommandHandler.deleteProgrammingLanguageCodeQuestion(command);
    }
}
