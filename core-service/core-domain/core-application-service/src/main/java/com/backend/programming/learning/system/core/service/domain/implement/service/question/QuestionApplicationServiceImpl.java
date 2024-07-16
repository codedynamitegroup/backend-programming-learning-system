package com.backend.programming.learning.system.core.service.domain.implement.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionCloneCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionCloneResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.QuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.*;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.handler.QuestionCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
@Validated
@Slf4j
public class QuestionApplicationServiceImpl implements QuestionApplicationService {
    private final QuestionCommandHandler questionQueryCommandHandler;

    public QuestionApplicationServiceImpl(QuestionCommandHandler questionQueryCommandHandler) {
        this.questionQueryCommandHandler = questionQueryCommandHandler;
    }

    @Override
    public QuestionResponseEntity queryQuestionById(UUID questionId) {
        return questionQueryCommandHandler.queryQuestionById(questionId);
    }

    @Override
    public List<QuestionResponseEntity> queryAllQuestion() {
        return questionQueryCommandHandler.queryAllQuestion();
    }

    @Override
    public QuestionDeleteResponse deleteQuestionById(UUID questionId) {
        return questionQueryCommandHandler.deleteQuestionById(questionId);
    }

    @Override
    public QueryAllQuestionByCategoryIdResponse queryAllQuestionByCategory(
            UUID categoryId,
            QueryAllQuestionByCategoryIdCommand queryAllQuestionByCategoryIdCommand
    ) {
        return questionQueryCommandHandler.queryAllQuestionByCategory(categoryId, queryAllQuestionByCategoryIdCommand);
    }

    @Override
    public QueryAllQuestionByCategoryIdResponse queryAllQuestionByCategoryAndIsBasicType(
            UUID categoryId,
            QueryAllQuestionByCategoryIdCommand queryAllQuestionByCategoryIdCommand,
            boolean isBasicType
    ) {
        return questionQueryCommandHandler.queryAllQuestionByCategoryAndIsBasicType(
                categoryId,
                queryAllQuestionByCategoryIdCommand,
                isBasicType);
    }

    @Override
    public QueryByIdsResponse queryAllQuestionDetail(QueryByIdsCommand ids) {
        return questionQueryCommandHandler.queryAllQuestionDetail(ids);
    }

    @Override
    public CreateQuestionCloneResponse cloneQuestion(CreateQuestionCloneCommand createQuestionCloneCommand) {
        return questionQueryCommandHandler.cloneQuestion(createQuestionCloneCommand);
    }

    @Override
    public QueryAllQuestionWithPaginationResponse queryAllQuestionWithPagination(QueryAllQuestionPaginationCommand queryAllQuestionPaginationCommand) {
        return questionQueryCommandHandler.queryAllQuestionWithPagination(queryAllQuestionPaginationCommand);
    }
}
