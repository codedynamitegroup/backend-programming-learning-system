package com.backend.programming.learning.system.core.service.domain.ports.input.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeShortanswerQuestionResponse;

import java.util.List;
import java.util.UUID;

public interface QtypeShortanswerQuestionApplicationService {
    CreateQuestionResponse createQtypeShortanswerQuestion(CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand);
    QueryQtypeShortanswerQuestionResponse queryQtypeShortanswerQuestionById(UUID qtShortanswerQuestionId);
    List<QueryQtypeShortanswerQuestionResponse> queryAllQtypeShortanswerQuestions();
}
