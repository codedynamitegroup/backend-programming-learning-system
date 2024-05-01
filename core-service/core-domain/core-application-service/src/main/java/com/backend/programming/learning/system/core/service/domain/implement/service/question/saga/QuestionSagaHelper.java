package com.backend.programming.learning.system.core.service.domain.implement.service.question.saga;

import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class QuestionSagaHelper {
    private final QuestionRepository questionRepository;

    public QuestionSagaHelper(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question findQuestionById(UUID questionId) {
        Optional<Question> question = questionRepository.findQuestion(questionId);

        if (question.isEmpty()) {
            log.warn("Question not found with id: {}", questionId);
            throw new QuestionNotFoundException("Question not found with id: " + questionId);
        }

        return question.get();
    }

    public SagaStatus questionStatusToSagaStatus(CopyState copyState) {
        return switch (copyState) {
            case CREATING,UPDATING,DELETING -> SagaStatus.STARTED;
            case UPDATE_PROPAGATING, DELETE_PROPAGATING, CREATE_PROPAGATING-> SagaStatus.PROCESSING;
            case CREATE_ROLLBACKING, DELETE_ROLLBACKING, UPDATE_ROLLBACKING-> SagaStatus.COMPENSATING;
            case CREATED,UPDATED,DELETED -> SagaStatus.SUCCEEDED;
            case CREATE_FAILED, UPDATE_FAILED, DELETE_FAILED -> SagaStatus.COMPENSATED;
        };
    }
}
