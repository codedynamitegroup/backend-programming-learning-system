package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.message.CodeQuestionsUpdateRequest;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllAdminQtypeCodeQuestionsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeCodeQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QtypeCodeQuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdatePayload;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.QtypeCodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class QtypeCodeQuestionDataMapper {
    private final QuestionDataMapper questionDataMapper;

    public QtypeCodeQuestionDataMapper(QuestionDataMapper questionDataMapper) {
        this.questionDataMapper = questionDataMapper;
    }

    public QtypeCodeQuestion codeQuestionsUpdateRequestToQtypeCodeQuestion(CodeQuestionsUpdateRequest request){
        return QtypeCodeQuestion.builder()
                .id(new QtypeCodeQuestionId(UUID.fromString(request.getCodeQuestionId())))
                .question(Question.builder()
                        .questionId(new QuestionId(UUID.fromString(request.getQuestionId())))
                        .build())
                .dslTemplate(null)
                .isPublic(false)
                .maxGrade(request.getMaxGrade())
                .problemStatement(request.getProblemStatement())
                .codeQuestionName(request.getName())
                .build();
    }
    public CodeQuestionsUpdatePayload codeQuestionsUpdateRequestToCodeQuestionsUpdatePayload(CodeQuestionsUpdateRequest request){
        return CodeQuestionsUpdatePayload.builder()
                .id(request.getId())
                .codeQuestionId(request.getCodeQuestionId())
                .sagaId(request.getSagaId())
                .questionId(request.getQuestionId())
                .problemStatement(request.getProblemStatement())
                .maxGrade(request.getMaxGrade())
                .name(request.getName())
//                .constraints(request.getConstraints())
                .build();
    }

    public QtypeCodeQuestion createQuestionCommandToQtypeCodeQuestion(CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand,
                                                                      Question question) {
        return QtypeCodeQuestion.builder()
                .question(question)
                .codeQuestionName(createQtypeCodeQuestionCommand.getName())
                .build();
    }

    public QueryQtypeCodeQuestionResponse qtypeCodeQuestionToQueryQtypeCodeQuestionResponse(QtypeCodeQuestion qtypeCodeQuestion) {
        return QueryQtypeCodeQuestionResponse.builder()
                .qtypeCodeQuestion(qtypeCodeQuestionToQtypeCodeQuestionResponseEntity(qtypeCodeQuestion))
                .build();
    }

    public List<QueryQtypeCodeQuestionResponse> qtypeCodeQuestionsToQueryQtypeCodeQuestionResponses(List<QtypeCodeQuestion> qtypeCodeQuestions) {
        return List.of(qtypeCodeQuestions.stream()
                .map(this::qtypeCodeQuestionToQueryQtypeCodeQuestionResponse)
                .toArray(QueryQtypeCodeQuestionResponse[]::new));
    }

    public QtypeCodeQuestion updateQtypeCodeQuestionCommandToQtypeCodeQuestion(UpdateQtypeCodeQuestionCommand updateQtypeCodeQuestionCommand,
                                                                               Question prevQuestion,
                                                                               QtypeCodeQuestion qtypeCodeQuestion) {

        return QtypeCodeQuestion.builder()
                .id(new QtypeCodeQuestionId(updateQtypeCodeQuestionCommand.getQtCodeQuestionId()))
                .dslTemplate(updateQtypeCodeQuestionCommand.getDslTemplate())
                .problemStatement(updateQtypeCodeQuestionCommand.getProblemStatement())
                .codeQuestionName(updateQtypeCodeQuestionCommand.getName())
                .maxGrade(updateQtypeCodeQuestionCommand.getMaxGrade())
                .question(questionDataMapper
                        .updateQuestionEntityToQuestion(updateQtypeCodeQuestionCommand.getQuestion(),
                                prevQuestion,
                                qtypeCodeQuestion.getQuestion().getId(),
                                qtypeCodeQuestion.getQuestion().getOrganization(),
                                qtypeCodeQuestion.getQuestion().getCreatedBy(),
                                qtypeCodeQuestion.getQuestion().getqtype(),
                                qtypeCodeQuestion.getQuestion().getAnswers()))
                .build();
    }

    private QtypeCodeQuestionResponseEntity qtypeCodeQuestionToQtypeCodeQuestionResponseEntity(QtypeCodeQuestion qtypeCodeQuestion) {
        return QtypeCodeQuestionResponseEntity.builder()
                .question(questionDataMapper.questionToQuestionResponseEntity(qtypeCodeQuestion.getQuestion()))
                .id(qtypeCodeQuestion.getId().getValue().toString())
                .dslTemplate(qtypeCodeQuestion.getDslTemplate())
                .problemStatement(qtypeCodeQuestion.getProblemStatement())
                .codeQuestionName(qtypeCodeQuestion.getCodeQuestionName())
                .maxGrade(qtypeCodeQuestion.getMaxGrade())
                .isPublic(qtypeCodeQuestion.getPublic())
                .build();
    }

    public QueryAllAdminQtypeCodeQuestionsResponse qtypeCodeQuestionsToQueryAllAdminQtypeCodeQuestionsResponse
            (Page<QtypeCodeQuestion> qtypeCodeQuestions) {
        return QueryAllAdminQtypeCodeQuestionsResponse.builder()
                .qtypeCodeQuestions(qtypeCodeQuestions
                        .map(this::qtypeCodeQuestionToQtypeCodeQuestionResponseEntity)
                        .toList())
                .currentPage(qtypeCodeQuestions.getNumber())
                .totalPages(qtypeCodeQuestions.getTotalPages())
                .totalItems(qtypeCodeQuestions.getTotalElements())
                .build();
    }
}
