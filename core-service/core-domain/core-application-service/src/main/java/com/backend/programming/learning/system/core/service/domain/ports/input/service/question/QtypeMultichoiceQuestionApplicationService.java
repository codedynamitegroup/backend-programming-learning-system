package com.backend.programming.learning.system.core.service.domain.ports.input.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeMultichoiceQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface QtypeMultichoiceQuestionApplicationService {
    CreateQuestionResponse createQtypeMultichoiceQuestion(@Valid CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand);
    QueryQtypeMultichoiceQuestionResponse queryQtypeMultichoiceQuestionById(UUID qtMultichoiceQuestionId);
    QueryQtypeMultichoiceQuestionResponse queryQtypeMultichoiceQuestionByQuestionId(UUID qtMultichoiceQuestionId);
    List<QueryQtypeMultichoiceQuestionResponse> queryAllQtypeMultichoiceQuestion();
    UpdateQuestionResponse updateQtypeMultichoiceQuestion(@Valid UpdateQtypeMultichoiceQuestionCommand updateQtypeMultichoiceQuestionCommand);
}
