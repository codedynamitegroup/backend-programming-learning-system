package com.backend.programming.learning.system.core.service.domain.implement.service.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeEssayQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.create.QtypeEssayQuestionCreateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query.QtypeEssayQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.update.QtypeEssayQuestionUpdateHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.question.QuestionCreatedMessagePublisher;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.question.QuestionUpdatedMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class QtypeEssayQuestionCommandHandler {
    private final QtypeEssayQuestionCreateHelper qtypeEssayQuestionCreateHelper;
    private final QtypeEssayQuestionQueryHelper qtypeEssayQuestionQueryHelper;
    private final QtypeEssayQuestionUpdateHelper qtypeEssayQuestionUpdateHelper;

    private final QuestionUpdatedMessagePublisher questionUpdatedMessagePublisher;
    private final QuestionCreatedMessagePublisher questionCreatedMessagePublisher;

    private final QuestionDataMapper questionDataMapper;


    public QtypeEssayQuestionCommandHandler(QtypeEssayQuestionCreateHelper qtypeEssayQuestionCreateHelper,
                                            QtypeEssayQuestionQueryHelper qtypeEssayQuestionQueryHelper,
                                            QtypeEssayQuestionUpdateHelper qtypeEssayQuestionUpdateHelper,
                                            QuestionUpdatedMessagePublisher questionUpdatedMessagePublisher,
                                            QuestionCreatedMessagePublisher questionCreatedMessagePublisher,
                                            QuestionDataMapper questionDataMapper) {
        this.qtypeEssayQuestionCreateHelper = qtypeEssayQuestionCreateHelper;
        this.qtypeEssayQuestionQueryHelper = qtypeEssayQuestionQueryHelper;
        this.qtypeEssayQuestionUpdateHelper = qtypeEssayQuestionUpdateHelper;
        this.questionUpdatedMessagePublisher = questionUpdatedMessagePublisher;
        this.questionCreatedMessagePublisher = questionCreatedMessagePublisher;
        this.questionDataMapper = questionDataMapper;
    }

    public CreateQuestionResponse createQtypeEssayQuestion(CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeEssayQuestionCreateHelper.persistQtypeEssayQuestion(createQtypeEssayQuestionCommand);

        questionCreatedMessagePublisher.publish(questionCreatedEvent);

        return questionDataMapper.questionCreatedEventToCreateQuestionResponse(questionCreatedEvent, "Qtype Essay Question created successfully");
    }

    public QueryQtypeEssayQuestionResponse queryQtypeEssayQuestionById(UUID qtEssayQuestionId) {
        return qtypeEssayQuestionQueryHelper.queryQtypeEssayQuestionById(qtEssayQuestionId);
    }

    public List<QueryQtypeEssayQuestionResponse> queryAllQtypeEssayQuestion() {
        return qtypeEssayQuestionQueryHelper.queryAllQtypeEssayQuestion();
    }

    public UpdateQuestionResponse updateQtypeEssayQuestion(UpdateQtypeEssayQuestionCommand updateQtypeEssayQuestionCommand) {
        QuestionUpdatedEvent questionUpdatedEvent = qtypeEssayQuestionUpdateHelper.updateQtypeEssayQuestion(updateQtypeEssayQuestionCommand);

        questionUpdatedMessagePublisher.publish(questionUpdatedEvent);

        return questionDataMapper.questionUpdatedEventToUpdateQuestionRespond(questionUpdatedEvent, "Qtype Essay Question updated successfully");
    }
}
