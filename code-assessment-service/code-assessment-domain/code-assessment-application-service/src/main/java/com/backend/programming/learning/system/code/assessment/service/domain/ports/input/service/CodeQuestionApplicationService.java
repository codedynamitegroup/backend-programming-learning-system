package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service;

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
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface CodeQuestionApplicationService {
    CreateCodeQuestionResponse createCodeQuestion(@Valid CreateCodeQuestionCommand command);

    GetCodeQuestionsResponse getPublicCodeQuestions(@Valid GetCodeQuestionsQuery query);

    void updateCodeQuestion(@Valid UpdateCodeQuestionCommand command);

    List<CodeQuestionDto> getDetailCodeQuestion(@Valid GetDetailCodeQuestionCommand command);

    void updateLanguageOfCodeQuestion(@Valid UpdateLanguageOfCodeQuestionCommand command);

    void deleteProgrammingLanguageCodeQuestion(@Valid DeleteLanguageToCodeQuestionCommand command);

    void addTagToCodeQuestion(@Valid AddTagToCodeQuestionCommand command);

    void deleteCodeQuestionTag(@Valid DeleteCodeQuestionTagCommand command);

    List<CodeQuestionDto> getRecommendedCodeQuestion(String email);

    GetCodeQuestionsResponse getAdminCodeQuestions(@Valid GetCodeQuestionsQuery query);

    CodeQuestionAdminDto getAdminDetailCodeQuestion(@Valid AdminDetailCodeQuestionQuery query);

    void deleteCodeQuestion(UUID codeQuestionId);
}
