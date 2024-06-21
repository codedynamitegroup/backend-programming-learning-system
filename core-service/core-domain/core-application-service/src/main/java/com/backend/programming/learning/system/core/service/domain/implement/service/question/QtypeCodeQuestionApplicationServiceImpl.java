package com.backend.programming.learning.system.core.service.domain.implement.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllAdminCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllAdminQtypeCodeQuestionsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeCodeQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.handler.QtypeCodeQuestionCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeCodeQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
@Validated
@Slf4j
public class QtypeCodeQuestionApplicationServiceImpl implements QtypeCodeQuestionApplicationService {
    private final QtypeCodeQuestionCommandHandler qtypeCodeQuestionCommandHandler;

    public QtypeCodeQuestionApplicationServiceImpl(QtypeCodeQuestionCommandHandler qtypeCodeQuestionCommandHandler) {
        this.qtypeCodeQuestionCommandHandler = qtypeCodeQuestionCommandHandler;
    }

    @Override
    public CreateQuestionResponse createQtypeCodeQuestion(CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand) {
        return qtypeCodeQuestionCommandHandler.createQtypeCodeQuestion(createQtypeCodeQuestionCommand);
    }

    @Override
    public QueryQtypeCodeQuestionResponse queryQtypeCodeQuestionById(UUID qtCodeQuestionId) {
        return qtypeCodeQuestionCommandHandler.queryQtypeCodeQuestionById(qtCodeQuestionId);
    }

    @Override
    public List<QueryQtypeCodeQuestionResponse> queryAllQtypeCodeQuestions() {
        return qtypeCodeQuestionCommandHandler.queryAllQtypeCodeQuestion();
    }

    @Override
    public UpdateQuestionResponse updateQtypeCodeQuestion(UpdateQtypeCodeQuestionCommand updateQtypeCodeQuestionCommand) {
        return qtypeCodeQuestionCommandHandler.updateQtypeCodeQuestion(updateQtypeCodeQuestionCommand);
    }

    @Override
    public QueryAllAdminQtypeCodeQuestionsResponse queryAllQtypeCodeQuestionsForAdmin(QueryAllAdminCodeQuestionCommand queryAllAdminCodeQuestionCommand) {
        return qtypeCodeQuestionCommandHandler.queryAllQtypeCodeQuestionsForAdmin(queryAllAdminCodeQuestionCommand);
    }

    @Override
    public QueryAllAdminQtypeCodeQuestionsResponse queryAllQtypeCodeQuestionsForOrgAdmin(QueryAllAdminCodeQuestionCommand queryAllAdminCodeQuestionCommand) {
        return qtypeCodeQuestionCommandHandler.queryAllQtypeCodeQuestionsForOrgAdmin(queryAllAdminCodeQuestionCommand);
    }

    @Override
    public QueryAllAdminQtypeCodeQuestionsResponse queryAllAllowedToImportQtypeCodeQuestionsForOrgAdmin(QueryAllAdminCodeQuestionCommand queryAllAdminCodeQuestionCommand) {
        return qtypeCodeQuestionCommandHandler.queryAllAllowedToImportQtypeCodeQuestionsForOrgAdmin(queryAllAdminCodeQuestionCommand);
    }
}
