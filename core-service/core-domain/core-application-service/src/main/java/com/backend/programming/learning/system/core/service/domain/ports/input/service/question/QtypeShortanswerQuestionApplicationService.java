package com.backend.programming.learning.system.core.service.domain.ports.input.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeShortanswerQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface QtypeShortanswerQuestionApplicationService {
    CreateQuestionResponse createQtypeShortanswerQuestion(@Valid CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand);
    QueryQtypeShortanswerQuestionResponse queryQtypeShortanswerQuestionById(UUID qtShortanswerQuestionId);
    List<QueryQtypeShortanswerQuestionResponse> queryAllQtypeShortanswerQuestions();
    UpdateQuestionResponse updateQtypeShortanswerQuestion(@Valid UpdateQtypeShortanswerQuestionCommand updateQtypeShortanswerQuestionCommand);
}
