package com.backend.programming.learning.system.core.service.domain.implement.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeShortanswerQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.create.QtypeShortanswerQuestionCreateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.query.QtypeShortanswerQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.update.QtypeShortanswerQuestionUpdateHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class QtypeShortanswerQuestionCommandHandler {
    private final QtypeShortanswerQuestionCreateHelper qtypeShortanswerCreateHelper;
    private final QtypeShortanswerQuestionQueryHelper qtypeShortanswerQuestionQueryHelper;
    private final QtypeShortanswerQuestionUpdateHelper qtypeShortanswerQuestionUpdateHelper;
    private final QuestionDataMapper questionDataMapper;

    public QtypeShortanswerQuestionCommandHandler(QtypeShortanswerQuestionCreateHelper qtypeShortanswerCreateHelper,
                                                  QtypeShortanswerQuestionQueryHelper qtypeShortanswerQuestionQueryHelper,
                                                  QtypeShortanswerQuestionUpdateHelper qtypeShortanswerQuestionUpdateHelper,
                                                  QuestionDataMapper questionDataMapper) {
        this.qtypeShortanswerCreateHelper = qtypeShortanswerCreateHelper;
        this.qtypeShortanswerQuestionQueryHelper = qtypeShortanswerQuestionQueryHelper;
        this.qtypeShortanswerQuestionUpdateHelper = qtypeShortanswerQuestionUpdateHelper;
        this.questionDataMapper = questionDataMapper;
    }

    public CreateQuestionResponse createQtypeShortanswerQuestion(CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeShortanswerCreateHelper.persistQtypeShortanswerQuestion(createQtypeShortanswerQuestionCommand);

        return questionDataMapper.questionCreatedEventToCreateQuestionResponse(questionCreatedEvent, "Qtype Shortanswer Question created successfully");
    }

    public QueryQtypeShortanswerQuestionResponse queryQtypeShortanswerQuestionById(UUID qtShortanswerQuestionId) {
        return qtypeShortanswerQuestionQueryHelper.queryQtypeShortanswerQuestionById(qtShortanswerQuestionId);
    }

    public List<QueryQtypeShortanswerQuestionResponse> queryAllQtypeShortanswerQuestions() {
        return qtypeShortanswerQuestionQueryHelper.queryAllQtypeShortanswerQuestions();
    }

    public UpdateQuestionResponse updateQtypeShortanswerQuestion(UpdateQtypeShortanswerQuestionCommand updateQtypeShortanswerQuestionCommand) {
        QuestionUpdatedEvent questionUpdatedEvent = qtypeShortanswerQuestionUpdateHelper.updateQtypeShortanswerQuestionInDb(updateQtypeShortanswerQuestionCommand);

        return questionDataMapper
                .questionUpdatedEventToUpdateQuestionRespond(questionUpdatedEvent, "Qtype Shortanswer Question updated successfully");
    }
}
