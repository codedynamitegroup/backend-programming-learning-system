package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CodeQuestionAdminDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CodeQuestionDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.langauge.UpdateLanguageOfCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.tag.AddTagToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.code_question.language.DeleteLanguageToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.code_question.tag.DeleteCodeQuestionTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.AdminDetailCodeQuestionQuery;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsQuery;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetDetailCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_question.UpdateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

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
    public GetCodeQuestionsResponse getPublicCodeQuestions(GetCodeQuestionsQuery query) {
        return codeQuestionCommandHandler.getPublicCodeQuestions(query);
    }

    @Override
    public void updateCodeQuestion(UpdateCodeQuestionCommand command) {
        codeQuestionCommandHandler.updateCodeQuestion(command);
    }

    @Override
    public List<CodeQuestionDto> getDetailCodeQuestion(GetDetailCodeQuestionCommand command) {
        return codeQuestionCommandHandler.getDetailCodeQuestion(command);
    }

    @Override
    public void updateLanguageOfCodeQuestion(UpdateLanguageOfCodeQuestionCommand command) {
        codeQuestionCommandHandler.updateLanguageOfCodeQuestion(command);
    }

    @Override
    public void deleteProgrammingLanguageCodeQuestion(DeleteLanguageToCodeQuestionCommand command) {
        codeQuestionCommandHandler.deleteProgrammingLanguageCodeQuestion(command);
    }

    @Override
    public void addTagToCodeQuestion(AddTagToCodeQuestionCommand command) {
        codeQuestionCommandHandler.addTagToCodeQuestion(command);
    }

    @Override
    public void deleteCodeQuestionTag(DeleteCodeQuestionTagCommand command) {
        codeQuestionCommandHandler.deleteCodeQuestionTag(command);
    }

    @Override
    public List<CodeQuestionDto> getRecommendedCodeQuestion(String email) {
        return codeQuestionCommandHandler.getRecommendedCodeQuestion(email);
    }

    @Override
    public GetCodeQuestionsResponse getAdminCodeQuestions(GetCodeQuestionsQuery query) {
        return codeQuestionCommandHandler.getAdminCodeQuestions(query);
    }

    @Override
    public CodeQuestionAdminDto getAdminDetailCodeQuestion(AdminDetailCodeQuestionQuery query) {
        return codeQuestionCommandHandler.getAdminDetailCodeQuestion(query);
    }
}
