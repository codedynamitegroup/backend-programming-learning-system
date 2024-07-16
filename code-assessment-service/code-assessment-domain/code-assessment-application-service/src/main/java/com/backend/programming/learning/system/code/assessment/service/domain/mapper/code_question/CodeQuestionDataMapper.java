package com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.DtoMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_question.UpdateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.event.code_question.CodeQuestionsUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdatePayload;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.code_question_tag.CodeQuestionTagId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CodeQuestionDataMapper {
    final DtoMapper dtoMapper;

    public CodeQuestionDataMapper(DtoMapper dtoMapper) {
        this.dtoMapper = dtoMapper;
    }

    public CodeQuestion createCodeQuestionCommandToCodeQuestion(CreateCodeQuestionCommand command, User user){
        return CodeQuestion.builder()
                .name(command.getName())
                .userId(user.getId())
                .orgId(command.getOrgId())
                .dslTemplate(command.getDslTemplate())
                .problemStatement(command.getProblemStatement())
                .inputFormat(command.getInputFormat())
                .outputFormat(command.getOutputFormat())
                .constraints(command.getConstraints())
                .copyState(CopyState.CREATING)
                .isPublic(command.getIsPublic())
                .difficulty(command.getDifficulty())
                .maxGrade(command.getMaxGrade())
                .allowImport(command.getAllowImport())
                .isQuestionBank(command.getIsQuestionBank())
                .build();
    }
    public CreateCodeQuestionResponse codeQuestionToCreateCodeQuestionReponse(CodeQuestion codeQuestion, String message){
        return CreateCodeQuestionResponse.builder()
                .codeQuestionId(codeQuestion.getId().getValue())
                .state(codeQuestion.getCopyState())
                .message(message)
                .build();
    }

    public CodeQuestionsUpdatePayload codeQuestionsUpdatedEventToCodeQuestionsUpdatePayload(CodeQuestionsUpdatedEvent event, CopyState state, UUID categoryBankId, String email){
        CodeQuestion codeQuestion = event.getCodeQuestion();
        return CodeQuestionsUpdatePayload.builder()
                .id(codeQuestion.getId().getValue().toString())
                .questionId(codeQuestion.getQuestionId().getValue().toString())
                .problemStatement(codeQuestion.getProblemStatement())
                .maxGrade(codeQuestion.getMaxGrade())
                .copyState(state.toString())
                .name(codeQuestion.getName())
                .allowImport(codeQuestion.getAllowImport())
                .isPublic(codeQuestion.getIsPublic())
                .isQuestionBank(codeQuestion.getQuestionBank())
                .categoryBankId(categoryBankId != null? categoryBankId.toString(): null)
                .orgId(codeQuestion.getOrgId() != null? codeQuestion.getOrgId().toString(): null)
                .email(email)
                .difficulty(codeQuestion.getDifficulty().name())
//                .constraints(codeQuestion.getConstraints())
                .build();
    }


    public CodeQuestionTagId codeQuestionIdAndTagIdToCodeQuestionTagId(CodeQuestionId id, TagId tagId) {
        return new CodeQuestionTagId(id, tagId);
    }

    public GetCodeQuestionsResponse pagableCodeQuestionsToGetCodeQuestionsResponse(Page<CodeQuestion> codeQuestions) {
        return GetCodeQuestionsResponse.builder()
                .currentPage(codeQuestions.getNumber())
                .totalItems(codeQuestions.getTotalElements())
                .totalPages(codeQuestions.getTotalPages())
                .codeQuestions(codeQuestions.stream().map(dtoMapper::codeQuestionToDtoIgnoreProblemStatement).toList())
                .build();
    }

    public CodeQuestion updateCodeQuestionCommandToCodeQuestion(UpdateCodeQuestionCommand command, User user) {
        return CodeQuestion.builder()
                .userId(user.getId())
                .name(command.getName())
                .problemStatement(command.getProblemStatement())
                .inputFormat(command.getInputFormat())
                .outputFormat(command.getOutputFormat())
                .constraints(command.getConstraints())
                .maxGrade(command.getMaxGrade())
                .difficulty(command.getDifficulty())
                .isPublic(command.getIsPublic())
                .allowImport(command.getAllowImport())
                .isQuestionBank(command.getIsQuestionBank())
                .build();
    }

}
